package com.servi.study.db._06_sharding_common_table;

import com.servi.study.db._00_entity.OrgMapper;
import com.servi.study.db._00_entity.OrgVO;
import com.servi.study.json.IJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class T01_ShardingCommonTable {

    @Autowired
    OrgMapper orgMapper;

    public void insert() {
        for (int i = 0; i < 10; i++) {
            OrgVO orgVO = new OrgVO();
            orgVO.setCode("code_" + i);
            orgVO.setName("name_" + i);
            orgMapper.insert(orgVO);
        }
    }

    public void query() {
        System.out.println(IJsonUtil.toJson(orgMapper.getAllOrgs()));
    }
}
