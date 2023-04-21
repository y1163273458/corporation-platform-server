package com.example.corporationplatformserver.controller;

import com.example.corporationplatformserver.common.vo.Code;
import com.example.corporationplatformserver.common.vo.Result;
import com.example.corporationplatformserver.entity.Activity;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    IActivityService activityService;

    @PostMapping("/some")
    public Result<List<Activity>> login(){
        List<Activity> data = activityService.getSome();
        if (data != null){
            System.out.println(data);
            return Result.success(20000,data,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
}
