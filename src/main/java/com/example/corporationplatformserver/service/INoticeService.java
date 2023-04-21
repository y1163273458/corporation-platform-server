package com.example.corporationplatformserver.service;

import com.example.corporationplatformserver.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.corporationplatformserver.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-18
 */
public interface INoticeService extends IService<Notice> {

    List<Notice> load(User user);

    Map<String, Object> detail(Notice notice);
}
