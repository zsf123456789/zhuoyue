package com.icis.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.icis.mapper.UserMapper;
import com.icis.pojo.UserInfo;
import com.icis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//接口实现类
//@Service
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //查询所有用户数据的方法
    @Override
    public List<UserInfo> findAll() {
        return userMapper.selectAll();
    }
}
