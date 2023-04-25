package com.example.corporationplatformserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.corporationplatformserver.common.vo.SystemDateTime;
import com.example.corporationplatformserver.entity.Activity;
import com.example.corporationplatformserver.entity.Notice;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.ActivityMapper;
import com.example.corporationplatformserver.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    SystemDateTime systemDateTime = new SystemDateTime();
    @Override
    public List getSome(){
        // 查询最新发布的10个活动
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Activity::getCreateTime);
        wrapper.eq(Activity::getPstatus,"已通过");
        wrapper.last("Limit 10");
        List<Activity> data = this.baseMapper.selectList(wrapper);
        if(data != null){
            return data;
        }
        return null;
    }

    @Override
    public Boolean create(Activity activity) {
        // 创建新的活动，并将审核状态设为“审核中”
        if(activity.getAid() != null){
            activity.setPstatus("审核中");
            activity.setUpdateTime(systemDateTime.getTime());
            int isSuccess = this.baseMapper.updateById(activity);
            if (isSuccess > 0){
                return Boolean.TRUE;
            }
        }else{
            activity.setCreateTime(systemDateTime.getTime());
            activity.setUpdateTime(systemDateTime.getTime());
            activity.setPstatus("审核中");
            Integer isSuccess = this.baseMapper.insert(activity);
            if (isSuccess > 0){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Map<String,List<Activity>> getMyActivity(String uid) {
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Activity::getCmid,uid);
        wrapper.orderByDesc(Activity::getUpdateTime);
        List<Activity> list = this.baseMapper.selectList(wrapper);
        if (list != null){
            Map<String,List<Activity>> data = new HashMap<>();
            data.put("activityList",list);
            return data;
        }
        return null;
    }

    @Override
    public Map<String,Activity> getOneItem(Integer aid) {
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Activity::getAid,aid);
        Activity activity = this.baseMapper.selectOne(wrapper);
        if(activity != null){
            HashMap<String, Activity> map = new HashMap<>();
            map.put("activity",activity);
            return map;
        }
        return null;
    }

    @Override
    public Map<String, List<Activity>> processList(String uid) {
        LambdaQueryWrapper<Activity> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Activity::getPstatus,"审核中");
        List<Activity> list = this.baseMapper.selectList(wrapper);
        if(list != null){
            HashMap<String, List<Activity>> map = new HashMap<>();
            map.put("activityList",list);
            return map;
        }
        return null;
    }

    @Override
    public Boolean agree(String pid, Integer aid) {
        Activity activity = new Activity();
        activity.setAid(aid);
        activity.setPid(pid);
        activity.setPstatus("已通过");
        activity.setAstatus("准备中");
        activity.setUpdateTime(systemDateTime.getTime());
        activity.setProcessTime(systemDateTime.getTime());
        int isSucess = this.baseMapper.updateById(activity);
        if (isSucess > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean refuse(String pid, Integer aid) {
        Activity activity = new Activity();
        activity.setAid(aid);
        activity.setPid(pid);
        activity.setPstatus("未通过");
        activity.setUpdateTime(systemDateTime.getTime());
        activity.setProcessTime(systemDateTime.getTime());
        int isSucess = this.baseMapper.updateById(activity);
        if (isSucess > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
