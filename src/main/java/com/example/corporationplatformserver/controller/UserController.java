package com.example.corporationplatformserver.controller;

import com.example.corporationplatformserver.common.vo.Code;
import com.example.corporationplatformserver.common.vo.Result;
import com.example.corporationplatformserver.entity.Corporationm;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.UserMapper;
import com.example.corporationplatformserver.service.ICorporationService;
import com.example.corporationplatformserver.service.ICorporationmService;
import com.example.corporationplatformserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Code code;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICorporationService corporationService;
    @Autowired
    private ICorporationmService corporationmService;

    @PostMapping("/info")
    public Result<Map<String,Object>> info(@RequestBody User userinfo){
//        Map<String,Object> data = userService.info(userinfo)
        return Result.fail(30000,code.getMessageByCode(30000));
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User userinfo){
        // 将接收的用户id、密码提交至service，判断是否存在该用户
        Map<String,Object> data = userService.login(userinfo);
        if (data != null){
            //根据该用户创建时间和最后更新时间判断该用户是否为首次登录,首次登录则需要该用户更改密码
            User user = (User) data.get("user");
            if (user.getCreateTime().equals(user.getUpdateTime())){
                return Result.success(20010,code.getMessageByCode(20010));
            }
//            Boolean isfirstlogin = userService.isFirstLogin(userinfo);
            // 根据用户id，判断是否加入了社团
            Corporationm corporationm = corporationmService.hasJoin(userinfo);
            // 如果该用户加入了社团则查询对应的社团名称
            if(corporationm != null){
                Map<String,Object> crop_map = new HashMap<>();
                crop_map.put("cid",corporationm.getCid());
                crop_map.put("cmlevel",corporationm.getCmlevel());
                Map<String,Object> corp_data = corporationService.getName(corporationm.getCid());
                if (corp_data != null){
                    crop_map.put("cname",corp_data.get("name"));
                    data.put("corp_info",crop_map);
                    return Result.success(20100,data,code.getMessageByCode(20100));
                }
            }
            System.out.println(data);
            return Result.success(20000,data,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
    //监听更改密码请求的接口
    @PostMapping("changepassword")
    public Result<Map<String,Object>> changepassword(@RequestBody User userinfo){
        Map<String,Object> data = userService.changepassword(userinfo);
        if (data != null){
            return Result.success(20011,data,code.getMessageByCode(20011));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
}

