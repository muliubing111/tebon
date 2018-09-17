package com.tebon.ams.controller;

import com.github.pagehelper.PageInfo;
import com.tebon.ams.model.entity.User;
import com.tebon.ams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-14
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //通过分页插件查询
    @RequestMapping(value="findList")
    public PageInfo<User> findList(){
        return userService.findUserList(2,4);
    }

}
