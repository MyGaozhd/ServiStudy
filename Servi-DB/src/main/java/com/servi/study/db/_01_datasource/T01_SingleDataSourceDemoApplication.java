package com.servi.study.db._01_datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class T01_SingleDataSourceDemoApplication implements CommandLineRunner {

    // @Resource == @Autowired
    @Resource
    private DataSource dataSource;

    // @Resource == @Autowired
    @Resource
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(T01_SingleDataSourceDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        showConnection();
//        showData();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO")
                .forEach(row -> log.info(row.toString()));
    }
}

