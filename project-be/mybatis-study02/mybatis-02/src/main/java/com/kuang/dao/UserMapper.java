package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from mybatis.user")
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
    int add(User user);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{uid}")
    int delete(@Param("uid") int id);

}
