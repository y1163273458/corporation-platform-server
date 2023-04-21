package com.example.corporationplatformserver.service.impl;

import com.example.corporationplatformserver.entity.Corporation;
import com.example.corporationplatformserver.mapper.CorporationMapper;
import com.example.corporationplatformserver.service.ICorporationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
