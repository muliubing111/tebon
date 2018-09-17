package com.tebon.ams.service;

import com.github.pagehelper.PageInfo;
import com.tebon.ams.model.entity.User;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-14
 **/
public interface UserService {
    void createUser(String name, Integer age);

    public PageInfo<User> findUserList(int page, int size);

    int addUser1(String name, Integer age);
    int addUser2(String name, Integer age);
    int addUser1AndUser2(String name, Integer age);
    int addUsers(String name, Integer age);
}
