package com.example.corporationplatformserver.service.impl;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.corporationplatformserver.common.vo.SystemDateTime;
import com.example.corporationplatformserver.entity.User;
import com.example.corporationplatformserver.mapper.UserMapper;
import com.example.corporationplatformserver.service.IUserService;
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
 * @since 2023-04-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Map<String, Object> login(User userinfo) {
        //根据uid和password查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUid,userinfo.getUid());
        wrapper.eq(User::getUpassword,userinfo.getUpassword());
        User login_user = this.baseMapper.selectOne(wrapper);
        if (login_user != null){
            //生成user的token
            Map<String, Object> data = new HashMap<>();
            data.put("token",UUID.randomUUID());
            data.put("user",login_user);
            return data;
        }
        return null;
    }

    @Override
    public String getUName(String uid) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUid,uid);
        User user = this.baseMapper.selectOne(wrapper);
        if (user != null){
            return user.getUname();
        }
        return null;
    }

    @Override
    public Map<String, Object> changepassword(User userinfo) {
        userinfo.setUpdateTime(new SystemDateTime().getTime());

        System.out.println("=========" + userinfo);
        int result = this.baseMapper.updateById(userinfo);
        if(result > 0){
            return this.login(userinfo);
        }
        return null;
    }
}
