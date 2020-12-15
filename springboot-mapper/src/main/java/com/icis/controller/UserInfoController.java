package com.icis.controller;

import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用户控制层
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    //查询所有用户数据
    @GetMapping("/findAll")
    public List<UserInfo> findAll(){
        List<UserInfo> allUser = this.userInfoService.findAll();
        return allUser;
    }

    //根据用户属性字段查询用户
    @GetMapping("/findByUserInfo")
    public List<UserInfo> findByUserInfo(UserInfo userInfo){
        List<UserInfo> allUser = this.userInfoService.findByUserInfo(userInfo);
        return allUser;
    }

    //根据用户名字模糊查询
    @GetMapping("/findUserByName")
    public List<UserInfo> findByUserLike(UserInfo userInfo){
        List<UserInfo> byUserLike = this.userInfoService.findByUserLike(userInfo);
        return byUserLike;
    }

    //添加用户的方法
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        this.userInfoService.addUser(userInfo);
        return "OK";
    }

    //添加用户数据  有选择性的添加  null不添加
    @PostMapping("/addUserSelective")
    public String addUserSelective(@RequestBody UserInfo userInfo){
        this.userInfoService.addUserSelective(userInfo);
        return "OK";
    }

    //根据主键更新用户
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody UserInfo userInfo){
        this.userInfoService.updateUser(userInfo);
        return "OK";
    }

    //根据主键更新属性不为null的值
    @PostMapping("/updateUserSelective")
    public String updateUserSelective(@RequestBody UserInfo userInfo){
        this.userInfoService.updateUserSelective(userInfo);
        return "OK";
    }

    //根据主键字段进行删除 方法参数必须包含完整的主键属性
    @GetMapping("/delByKey")
    public String deleteUserByKey( @RequestBody UserInfo userInfo){
        this.userInfoService.deleteUserByKey(userInfo);
        return "delete by key OK";
    }

    //根据实体字段属性作为条件删除用户 查询条件用等号
    @GetMapping("/delByUser")
    public String deleteUserByUser( @RequestBody UserInfo userInfo){
        this.userInfoService.deleteUserByUser(userInfo);
        return "delete by user OK";
    }
    //根据实体中的属性查询总数
    @GetMapping("/selectCount")
    public Integer selectCountByUser(UserInfo userInfo){
        Integer countByUser = this.userInfoService.selectCountByUser(userInfo);
        return countByUser;
    }
    //根据name属性模糊查询用户
    @GetMapping("/selectCountByName")
    public Integer selectCountByNameLike(UserInfo userInfo){
        return this.userInfoService.selectCountByNameLike(userInfo);
    }
}
