package com.tebon.ams.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tebon.ams.ams.User1Mapper;
import com.tebon.ams.ams1.User2Mapper;
import com.tebon.ams.model.entity.User;
import com.tebon.ams.model.entity.UserExample;
import com.tebon.ams.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-14
 **/
@Service
public class UserServiceImpl implements UserService{

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

   // @Autowired
   // private UserMapper userMapper;

    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    public void createUser(String name, Integer age) {
        //jdbcTemplate.update("insert into user values(null,?,?);", name, age);
    }

    public PageInfo<User> findUserList(int page, int size){
        PageHelper.startPage(page, size);
        List<User> listUser = user1Mapper.selectByExample(new UserExample());
        // 封装分页之后的数据
        PageInfo<User> pageInfoUser = new PageInfo<User>(listUser);

        return pageInfoUser;
    }


    //多数据源
    @Transactional
    public int addUser1(String name, Integer age){
        int n = user1Mapper.addUser(name,age);
        int i = 1/0;
        return n;
    }

    //@Transactional(transactionManager = "amsTransactionManager")
    public int addUser2(String name, Integer age){
        int n = user2Mapper.addUser(name,age);
        int i = 1/0;

        return n;
    }

    //没加分布式事务
    //@Transactional(transactionManager = "ams1TransactionManager")
    public  int addUser1AndUser2(String name, Integer age){
        int n1 = user1Mapper.addUser(name, age);
        int n2 = user2Mapper.addUser(name, age);

        int i =1/0;
        return  n1+n2;

    }

    //加分布式事务
    @Transactional
    public  int addUsers(String name, Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        int n1 = user1Mapper.insert(user);
        int n2 = user2Mapper.insert(user);

        return  n1+n2;

    }
}
