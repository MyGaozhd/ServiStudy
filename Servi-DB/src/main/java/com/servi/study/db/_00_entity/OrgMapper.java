package com.servi.study.db._00_entity;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrgMapper {

    @Select("select * from org_orgs order by id asc")
    public List<OrgVO> getAllOrgs();

    @Select("select * from org_orgs where code =${code}")
    public OrgVO getUserByUserId(String code);

    @Insert("insert into org_orgs(code,name) values (#{code},#{name})")
    @Options(useGeneratedKeys = true)
    public void insert(OrgVO orgVO);
}
