package com.example.corporationplatformserver.controller;

import com.example.corporationplatformserver.common.vo.Code;
import com.example.corporationplatformserver.common.vo.Result;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.UserMapper;
import com.example.corporationplatformserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @PostMapping("/info")
    public Result<Map<String,Object>> info(@RequestBody User userinfo){
//        Map<String,Object> data = userService.info(userinfo)
        return Result.fail(30000,code.getMessageByCode(30000));
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User userinfo){
        Map<String,Object> data = userService.login(userinfo);
        if (data != null){
            System.out.println(data);
            return Result.success(20000,data,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }

}

