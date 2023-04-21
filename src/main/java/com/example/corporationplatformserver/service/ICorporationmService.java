package com.example.corporationplatformserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.corporationplatformserver.controller.CorporationmController;
import com.example.corporationplatformserver.entity.Corporationm;
import com.example.corporationplatformserver.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-17
 */
public interface ICorporationmService extends IService<Corporationm> {

    Corporationm hasJoin(User userinfo);
}
