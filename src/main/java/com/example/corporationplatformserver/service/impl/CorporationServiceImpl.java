package com.example.corporationplatformserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.corporationplatformserver.entity.Corporation;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.CorporationMapper;
import com.example.corporationplatformserver.service.ICorporationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-18
 */
@Service
public class CorporationServiceImpl extends ServiceImpl<CorporationMapper, Corporation> implements ICorporationService {
    @Override
    public Map<String, Object> getName(String cid){
        //根据uid和password查询
        LambdaQueryWrapper<Corporation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Corporation::getCid,cid);
        Corporation corporation = this.baseMapper.selectOne(wrapper);
        if (corporation != null){
            //生成user的token
            Map<String, Object> data = new HashMap<>();
            data.put("name",corporation.getCname());
            return data;
        }
        return null;
    }
}
