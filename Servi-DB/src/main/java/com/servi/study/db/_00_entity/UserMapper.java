package com.servi.study.db._00_entity;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user order by user_id asc")
    public List<User> getAllUser();

    @Select("select * from user where user_id =${user_id}")
    public User getUserByUserId(String user_id);

    @Insert("insert into user(user_id,name,sex,age) values (#{user_id},#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true)
    public void insertUser(User user);

    @Delete("delete from user")
    public void deleteAllUser();
}
