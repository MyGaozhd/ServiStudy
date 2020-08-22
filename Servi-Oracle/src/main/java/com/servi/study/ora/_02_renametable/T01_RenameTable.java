package com.servi.study.ora._02_renametable;

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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class T01_RenameTable implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static ExecutorService service = Executors.newFixedThreadPool(20);

    @Override
    public void run(String... args) throws Exception {
        //使用oracle放开
//        showConnection();
//        showData();

        resumeSSCDB();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("select table_name from user_tables")
                .forEach(row -> {
                    renameSSCDB(row);
                });

    }

    private static Set<String> tables = new HashSet<>();

    private static Set<String> ssc_need_tables = new HashSet<>();
    private static Set<String> ssc_tables = new HashSet<>();


    static {
        String[] sntable = TablesD.sscneedtable.split(";");

        for (String t : sntable) {
            ssc_need_tables.add(t.toLowerCase());
        }

        String stable[] = TablesD.ssctable.split(";");
        for (String t : stable) {
            ssc_tables.add(t.toLowerCase());
        }


    }

    private static String pifx = "_s_";

    public void renameSSCDB(Map<String, Object> row) {
        String table = ((String) row.get("table_name")).toLowerCase();
        tables.add(table);
        if (!ssc_tables.contains(table) && !ssc_need_tables.contains(table) && !table.startsWith("saga")) {
            String sql = " alter table " + table + " rename to " + table.substring(0, table.length() - 3) + pifx;
            String sql1 = " alter table " + table + " rename to " + table + pifx;
            try {
                jdbcTemplate.execute(sql);
            } catch (Exception e) {
                try {
                    jdbcTemplate.execute(sql1);
                } catch (Exception e1) {
                    log.info(sql1);
                }
            }
        }
    }

    public void resumeSSCDB() {
        for (String table : ssc_need_tables) {
            String sql = " alter table " + table.substring(0, table.length() - 3) + pifx + " rename to " + table;
            String sql1 = " alter table " + table + pifx + " rename to " + table;
            try {
                jdbcTemplate.execute(sql);
            } catch (Exception e) {
                try {
                    jdbcTemplate.execute(sql1);
                } catch (Exception e1) {
                    log.info(sql1);
                }
            }
        }


        for (String table : ssc_tables) {
            String sql = " alter table " + table.substring(0, table.length() - 3) + pifx + " rename to " + table;
            String sql1 = " alter table " + table + pifx + " rename to " + table;
            try {
                jdbcTemplate.execute(sql);
            } catch (Exception e) {
                try {
                    jdbcTemplate.execute(sql1);
                } catch (Exception e1) {
                    log.info(sql1);
                }
            }
        }


    }

    public void renameUAPDB(Map<String, Object> row) {
        String table = ((String) row.get("table_name")).toLowerCase();

//        if (ssc_tables.contains(table)) {
//            String sql = " alter table " + table + " rename to " + table + pifx;
//            jdbcTemplate.execute(sql);
//            log.info(sql);
//        }

        if (ssc_tables.contains(table)) {
            String sql = " alter table " + table + " rename to " + table.substring(0, table.length() - 3) + pifx;
            String sql1 = " alter table " + table + " rename to " + table + pifx;
            try {
                jdbcTemplate.execute(sql);
            } catch (Exception e) {
                try {
                    jdbcTemplate.execute(sql1);
                } catch (Exception e1) {
                    log.info(sql1);
                }
            }
        }
    }

}

