package com.servi.study.db._07_sharding_read_write;

import com.servi.study.db._00_entity.GroupMapper;
import com.servi.study.db._00_entity.GroupVO;
import com.servi.study.db._00_entity.OrgMapper;
import com.servi.study.db._00_entity.OrgVO;
import com.servi.study.json.IJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class T01_ShardingReadWrite {

    @Autowired
    GroupMapper groupMapper;

    public void insert() {
        for (int i = 0; i < 10; i++) {
            GroupVO groupVO = new GroupVO();
            groupVO.setCode("code_" + i);
            groupVO.setName("name_" + i);
            groupMapper.insert(groupVO);
        }
    }

    public void query() {
        System.out.println(IJsonUtil.toJson(groupMapper.getAll()));
    }
}
