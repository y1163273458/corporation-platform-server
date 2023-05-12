package com.example.corporationplatformserver.controller;

import com.example.corporationplatformserver.common.util.Task;
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
import javafx.beans.binding.Bindings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    @Autowired
    IActivityService activityService;
    @Autowired
    INoticeService noticeService;
    @Autowired
    IUserService userService;

    private String fileSavePath= "E:/project/corporation platform/corporation platform/static/activity-img";

    @PostMapping("/search")
    public Result<Map<String,Object>> search(@RequestBody Map<String,String> searchText){
        System.out.println("--------------------++++++++++++++++");
        System.out.println(searchText.get("searchText"));
        List<Activity> list = activityService.search(searchText.get("searchText"));
        Map<String,Object> data = new HashMap<>();
        data.put("activitylist",list);
        if (data != null){
            System.out.println(data);
            return Result.success(20000,data,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }

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
        activity.setNclick(0);
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
            //向管理员发送有活动待申请的通知
            Notice notice_need = new Notice();
            notice_need.setNcontent("你有新的活动( "+ activity.getAname() +" )需要审核。");
            notice_need.setNstatus("未读");
            notice_need.setSuid("10000000000");
            notice_need.setSuname("系统");
            notice_need.setGuid("12345678910");
            Boolean noticeneed = noticeService.create(notice_need);
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
    public Result<Map<String,Object>> agree(@RequestBody Activity activity){
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
    public Result<Map<String,Object>> refuse(@RequestParam long aid,@RequestParam String pid,@RequestParam String reason){
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
                System.out.println("+++++++++++++" + pid);
                notice_refuse.setSuname(userService.getUName(pid));
                System.out.println("+++++++++++++++" + userService.getUName(pid));
                System.out.println(notice_refuse);
                notice_refuse.setGuid(activity.getCmid());
                Boolean noticeCreateIsSuccess = noticeService.create(notice_refuse);
                return Result.success(20202,code.getMessageByCode(20202));
            }
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    @PostMapping("/upload")
    public Result<Map<String,Object>> upload(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String filePath = "";
        request.setCharacterEncoding("utf-8"); //设置编码
        String directory =simpleDateFormat.format(new Date());
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            //获取formdata的值
            Iterator<String> iterator = req.getFileNames();
            System.out.println("Iterator================="+iterator);
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                String fileName = file.getOriginalFilename();
                //真正写到磁盘上

                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String newFileName= UUID.randomUUID().toString().replaceAll("-", "")+suffix;
                //由于未设置服务器，所以此处将图片暂存至static文件夹，但此方法会造成微信开发者工具自动编译无法留在当前页面，所以最终选择直接传回一个固定的地址
//                File file1 = new File(fileSavePath+"/" + newFileName);
//                file.transferTo(file1);
//                System.out.println("filePath================="+file1.getPath());
                //这里进行了路径拼接，根据自己的存放路径进行修改即可。
                filePath = "/static/activity-img/"+ newFileName;
                System.out.println("==========" + filePath);
                Map<String,Object> data = new HashMap<>();
//                data.put("filePath",filePath);
                data.put("filePath","/static/activity-img/8e96fc8e282c4b67a89ab86cfcb70472.jpg");
                return Result.success(21000,data,code.getMessageByCode(21000));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Result.fail(31000,code.getMessageByCode(31000));
    }
}
