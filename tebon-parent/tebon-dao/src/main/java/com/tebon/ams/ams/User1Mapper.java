package com.tebon.ams.ams;

import com.tebon.ams.model.entity.User;
import com.tebon.ams.model.entity.UserExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-15
 **/
public interface User1Mapper {
    @Insert("insert into user values(null,#{name},#{age});")
    public int addUser(@Param("name") String name, @Param("age") Integer age);

    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}

