package com.example.corporationplatformserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.corporationplatformserver.entity.User;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-17
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User userinfo);
}
