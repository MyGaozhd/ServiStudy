package com.servi.study.db._00_entity;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user ")
    public List<User> getAllUser();

    @Select("select * from user where userid =${id}")
    public User getUserByUserId(String userid);

    @Insert("insert into user(userid,name,sex,age) values (#{userid},#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true)
    public void insertUser(User user);

    @Delete("delete from user")
    public void deleteAllUser();
}
