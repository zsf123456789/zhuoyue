package com.icis.service.impl;

import com.icis.mapper.UserInfoMapper;
import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    //查询所有用户方法
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = this.userInfoMapper.selectAll();
        return userInfoList;
    }

    //根据用户属性字段查询用户数据
    @Override
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    //根据用户name属性模糊查询
    @Override
    public List<UserInfo> findByUserLike(UserInfo userInfo) {
        Example example=new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name","%"+userInfo.getName()+"%");
        List<UserInfo> infoList = this.userInfoMapper.selectByExample(example);
        return infoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        this.userInfoMapper.insert(userInfo);
    }

    @Override
    public void addUserSelective(UserInfo userInfo) {
        this.userInfoMapper.insertSelective(userInfo);
    }

    //根据主键更新用户 updateByPrimaryKey()如果没有主键不执行此操作
    @Override
    public void updateUser(UserInfo userInfo) {
        this.userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public void updateUserSelective(UserInfo userInfo) {
        this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    //根据主键属性参数用户 方法参数必须包含完整的主键属性
    @Override
    public void deleteUserByKey(UserInfo userInfo) {
        this.userInfoMapper.deleteByPrimaryKey(userInfo);
    }
    //根据实体字段属性作为条件删除用户  查询条件用等号
    @Override
    public void deleteUserByUser(UserInfo userInfo) {
        this.userInfoMapper.delete(userInfo);
    }
    //根据实体中属性查询总数
    @Override
    public Integer selectCountByUser(UserInfo userInfo) {
        int selectCount = this.userInfoMapper.selectCount(userInfo);
        return selectCount;
    }
    //根据name属性模糊查询用户
    @Override
    public Integer selectCountByNameLike(UserInfo userInfo) {
        Example example=new Example(UserInfo.class);
        example.createCriteria().andLike("name","%"+userInfo.getName()+"%");
        int i = this.userInfoMapper.selectCountByExample(example);
        return i;
    }
}
