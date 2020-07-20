package com.servi.study.db._07_sharding_read_write;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.servi.study.db._00_entity")
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class ServiShardingApplication implements CommandLineRunner {

    @Autowired
    T01_ShardingReadWrite t01_shardingCommonTable;

    public static void main(String[] args) {
        SpringApplication.run(ServiShardingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        t01_shardingCommonTable.insert();
        t01_shardingCommonTable.query();
    }
}
