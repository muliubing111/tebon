package com.tebon.ams.controller;

import com.tebon.ams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-15
 **/
@RestController
public class DataSourceController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user1")
    public int addUser1(String name, Integer age){
        return userService.addUser1(name,age);
    }

    @RequestMapping(value = "user2")
    public int addUser2(String name, Integer age){
        return userService.addUser2(name,age);
    }


    //多数据源（没有加分布式事务）
    @RequestMapping(value = "addUser1Anduser2")
    public int addUser1AndUser2(String name, Integer age){
        return userService.addUser1AndUser2(name, age);
    }

    //多数据源（加分布式事务）
    @RequestMapping(value = "addUsers")
    public int addUsers(String name, Integer age){
        return userService.addUsers(name, age);
    }
}
