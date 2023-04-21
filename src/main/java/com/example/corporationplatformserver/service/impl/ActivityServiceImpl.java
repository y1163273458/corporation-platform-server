package com.example.corporationplatformserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.corporationplatformserver.entity.Activity;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.ActivityMapper;
import com.example.corporationplatformserver.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-18
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {
    @Override
    public List getSome(){
        // 查询最新发布的10个活动
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Activity::getCreateTime);
        wrapper.last("Limit 10");
        List<Activity> data = this.baseMapper.selectList(wrapper);
        if(data != null){
            return data;
        }
        return null;
    }
}
