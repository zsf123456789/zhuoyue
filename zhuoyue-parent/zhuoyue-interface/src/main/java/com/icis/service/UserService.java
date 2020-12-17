package com.icis.service;

import com.icis.pojo.UserInfo;

import java.util.List;

//用户接口
public interface UserService {
    //查询所有用户数据
    public List<UserInfo> findAll();
}
