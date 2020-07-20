package com.servi.study.db._00_entity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Select("select * from org_group order by id asc")
    public List<GroupVO> getAll();

    @Insert("insert into org_group(code,name) values (#{code},#{name})")
    @Options(useGeneratedKeys = true)
    public void insert(GroupVO GroupVO);
}
