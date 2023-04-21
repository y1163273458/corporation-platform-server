package com.example.corporationplatformserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.corporationplatformserver.controller.CorporationmController;
import com.example.corporationplatformserver.entity.Corporationm;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.CorporationmMapper;
import com.example.corporationplatformserver.service.ICorporationmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YeKaihui
 * @since 2023-04-17
 */
@Service
public class CorporationmServiceImpl extends ServiceImpl<CorporationmMapper, Corporationm> implements ICorporationmService {

    @Override
    public Corporationm hasJoin(User userinfo) {
        LambdaQueryWrapper<Corporationm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Corporationm::getCmid,userinfo.getUid());
        Corporationm data = this.baseMapper.selectOne(wrapper);
        if (data != null){
            return data;
        }
        return null;
    }
}
