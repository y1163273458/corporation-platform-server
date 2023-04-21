package com.example.corporationplatformserver.controller;

import com.example.corporationplatformserver.common.vo.Code;
import com.example.corporationplatformserver.common.vo.Result;
import com.example.corporationplatformserver.entity.Notice;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    INoticeService noticeService;

    Code code;
    // 处理获取对应用户所有通知的需求
    @PostMapping("/load")
    public Result<List<Notice>> load(@RequestBody User user){
        List<Notice> list = noticeService.load(user);
        if(list != null){
            return Result.success(20000,list,code.getMessageByCode(20000));
        }
        return  Result.fail(30000,code.getMessageByCode(30000));
    }

    // 处理获取对应通知内容的需求
    @PostMapping("/detail")
    public Result<Map<String,Object>> detail(@RequestBody Notice notice){
        Map<String,Object> detail = noticeService.detail(notice);
        if (detail != null){
            return Result.success(20000,detail,code.getMessageByCode(20000));
        }
        return Result.fail(30000,code.getMessageByCode(30000));
    }
}
