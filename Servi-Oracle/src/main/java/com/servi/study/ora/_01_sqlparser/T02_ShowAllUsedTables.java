package com.servi.study.ora._01_sqlparser;

import com.servi.study.json.IJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class T02_ShowAllUsedTables implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        //使用oracle放开
        showConnection();
        showData();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("select sql_text,SQL_ID from v$sql")
                .forEach(row -> {
                    parseAllTable(row);
                });
        System.out.println("tables->           " + IJsonUtil.toJson(tables));
        System.out.println("size->           " + tables.size());
    }

    private static Set<String> tables = new HashSet<>();

    public void parseAllTable(Map<String, Object> row) {

    }
}

