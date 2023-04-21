package com.example.corporationplatformserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.corporationplatformserver.common.vo.SystemDateTime;
import com.example.corporationplatformserver.entity.Activity;
import com.example.corporationplatformserver.entity.Notice;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.NoticeMapper;
import com.example.corporationplatformserver.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    SystemDateTime dateTime =  new SystemDateTime();

    @Override
    public List<Notice> load(User user) {
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Notice::getGuid,user.getUid());
        wrapper.orderByDesc(Notice::getNstatus,Notice::getUpdateTime);
        List<Notice> data = this.baseMapper.selectList(wrapper);
        if(data != null){
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> detail(Notice notice) {
        Notice notice_update;

        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Notice::getNid,notice.getNid());
        Notice notice_select = this.baseMapper.selectOne(wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("notice",notice_select);

        System.out.println("1----"+data);
        //更新notice状态和时间
        notice_update = new Notice(notice_select);
        notice_update.setNstatus("已读");
        notice_update.setUpdateTime(dateTime.getTime());

        Integer result = this.baseMapper.updateById(notice_update);
        System.out.println(data);
        if (data != null){
            return data;
        }
        return null;
    }

}
