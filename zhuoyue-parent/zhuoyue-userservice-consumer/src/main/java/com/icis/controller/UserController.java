package com.icis.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icis.pojo.UserInfo;
import com.icis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class UserController {
    //@Autowired
    @Reference
    private UserService userService;

    //查询所有用户的方法
    @GetMapping("findAll")
    public List<UserInfo> findAll(){
        return this.userService.findAll();
    }
}
