package com.example.corporationplatformserver.service;

import com.example.corporationplatformserver.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface IActivityService extends IService<Activity> {
    List getSome();

}
