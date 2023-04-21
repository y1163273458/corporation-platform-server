package com.example.corporationplatformserver.service;

import com.example.corporationplatformserver.entity.Corporation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.corporationplatformserver.entity.User;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-18
 */
public interface ICorporationService extends IService<Corporation> {

    Map<String, Object> getName(String cid);
}
