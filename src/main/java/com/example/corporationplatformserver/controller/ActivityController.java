package com.example.corporationplatformserver.controller;

import com.example.corporationplatformserver.common.vo.Code;
import com.example.corporationplatformserver.common.vo.Result;
import com.example.corporationplatformserver.common.vo.SystemDateTime;
import com.example.corporationplatformserver.entity.Activity;
import com.example.corporationplatformserver.entity.ActivityReceive;
import com.example.corporationplatformserver.entity.Notice;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.UserMapper;
import com.example.corporationplatformserver.service.IActivityService;
import com.example.corporationplatformserver.service.INoticeService;
import com.example.corporationplatformserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-18
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    Code code;
    SystemDateTime systemDateTime = new SystemDateTime();
    @Autowired
    IActivityService activityService;
    @Autowired
    INoticeService noticeService;
    @Autowired
    IUserService userService;

    @PostMapping("/some")
    public Result<List<Activity>> login(){
        List<Activity> data = activityService.getSome();
        if (data != null){
            System.out.println(data);
            return Result.success(20000,data,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    @PostMapping("/create")
    public Result<List<Activity>> create(@RequestBody ActivityReceive activityReceive){
//        System.out.println(activityReceive);
        //创建一个Activity实例
        Activity activity = new Activity();
        //将activityReceive的信息传入activity，并将日期改为localdatetime类型
        if(activityReceive.getAid() != null){
            activity.setAid(activityReceive.getAid());
        }
        activity.setCmid(activityReceive.getCmid());
        activity.setCid(activityReceive.getCid());
        activity.setSstarttime(systemDateTime.format(activityReceive.getSstarttime()));
        activity.setSendtime(systemDateTime.format(activityReceive.getSendtime()));
        activity.setAstarttime(systemDateTime.format(activityReceive.getAstarttime()));
        activity.setAendtime(systemDateTime.format(activityReceive.getAendtime()));
        activity.setAname(activityReceive.getAname());
        activity.setAimage(activityReceive.getAimage());
        activity.setAcomment(activityReceive.getAcomment());
        activity.setAaddr(activityReceive.getAaddr());
        /**/
//        System.out.println(activity);
        Boolean isSuccess = activityService.create(activity);
        System.out.println(isSuccess);
        if (isSuccess){
            //向活动负责人发送提交申请通知
            Notice notice_creator = new Notice();
            notice_creator.setNcontent("你创建的活动( "+ activity.getAname() +" )已提交申请。");
            notice_creator.setNstatus("未读");
            notice_creator.setSuid("10000000000");
            notice_creator.setSuname("系统");
            notice_creator.setGuid(activity.getCmid());
            Boolean noticeCreateIsSuccess = noticeService.create(notice_creator);
            return Result.success(20000,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    @PostMapping("/myactivity")
    public Result<Map<String,List<Activity>>> getMyActivity(@RequestBody User user){
        Map<String,List<Activity>> data = activityService.getMyActivity(user.getUid());
        if (data != null){
            System.out.println(data);
            return Result.success(20100,data,code.getMessageByCode(20100));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    @PostMapping("/getone")
    public Result<Map<String,Activity>> getOneItem(@RequestBody Activity activity){
        System.out.println(activity);
        Map<String,Activity> data = activityService.getOneItem(activity.getAid());
        if (data != null){
            System.out.println(data);
            return Result.success(20000,data,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    @PostMapping("/processlist")
    public Result<Map<String,List<Activity>>> processlist(@RequestBody User user){
        Map<String,List<Activity>> data = activityService.processList(user.getUid());
        if (data != null){
            System.out.println(data);
            return Result.success(20200,data,code.getMessageByCode(20200));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    @PostMapping("/agree")
    public Result<Map<String,String>> agree(@RequestBody Activity activity){
        Boolean data = activityService.agree(activity.getPid(),activity.getAid());
        if (data){
            //向活动负责人发送申请成功通知
            Notice notice_agree = new Notice();
            notice_agree.setNcontent("你创建的活动( "+ activity.getAname() +" )已通过申请。");
            notice_agree.setNstatus("未读");
            notice_agree.setSuid(activity.getPid());
            notice_agree.setSuname(userService.getUName(activity.getPid()));
            notice_agree.setGuid(activity.getCmid());
            Boolean noticeCreateIsSuccess = noticeService.create(notice_agree);
            return Result.success(20201,code.getMessageByCode(20201));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    @GetMapping("/refuse")
    public Result<Map<String,String>> refuse(@RequestParam long aid,@RequestParam String pid,@RequestParam String reason){
        Activity activity = activityService.getById(aid);
        System.out.println("------------"+activity);
        if(activity != null){
            Boolean data = activityService.refuse(pid,activity.getAid());
            if (data != null){
                //向活动负责人发送申请失败通知
                Notice notice_refuse = new Notice();
                notice_refuse.setNcontent("你创建的活动( "+ activity.getAname() +" )未能通过申请。原因为：" + reason);
                notice_refuse.setNstatus("未读");
                notice_refuse.setSuid(pid);
                notice_refuse.setSuname(userService.getUName(activity.getPid()));
                notice_refuse.setGuid(activity.getCmid());
                Boolean noticeCreateIsSuccess = noticeService.create(notice_refuse);
                return Result.success(20202,code.getMessageByCode(20202));
            }
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
}
