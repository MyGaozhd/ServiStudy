package com.servi.study.db._05_sharding_db_table;

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
    T01_ShardingDBAndTable t01_shardingDBAndTable;

    public static void main(String[] args) {
        SpringApplication.run(ServiShardingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        t01_shardingDBAndTable.insert();
        t01_shardingDBAndTable.query();
    }
}
