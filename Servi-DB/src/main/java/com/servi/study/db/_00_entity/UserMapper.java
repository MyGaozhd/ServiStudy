package com.servi.study.db._00_entity;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user ")
    public List<User> getAllUser();

    @Select("select * from user where id =${id}")
    public User getUserById(String id);

    @Insert("insert into user(name,sex,age) values (#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true)
    public void insertUser(User user);

    @Delete("delete from user")
    public void deleteAllUser();
}
