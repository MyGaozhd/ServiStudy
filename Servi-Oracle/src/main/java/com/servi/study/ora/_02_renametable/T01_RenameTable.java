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
import java.util.*;
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
//        changeSSCDB();
//        resumeBaseData();
//        resumeSSCDB();
        changeBaseDB();

//        testSSCDB();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    int i = 0;

    private void changeSSCDB() {

        List<Map<String, Object>> ll = jdbcTemplate.queryForList("select table_name from user_tables");

        for (Map<String, Object> row : ll) {
            String table = ((String) row.get("table_name")).toLowerCase();
            renameSSCDB(table);
        }

        System.out.println(IJsonUtil.toJson(alltables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(tables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(errortables));
    }

    private void changeBaseDB() {

        List<Map<String, Object>> ll = jdbcTemplate.queryForList("select table_name from user_tables");

        for (Map<String, Object> row : ll) {
            renameUAPDB(row);
        }

        System.out.println(IJsonUtil.toJson(alltables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(tables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(errortables));
    }

    private void resumeBaseData() {

        String s = Test.get();
        Map<String, String> map = IJsonUtil.fromJson(Map.class, s);
        Map<String, String> newMap = new HashMap<>();

        for (String table : map.keySet()) {
            newMap.put(map.get(table).toLowerCase(), table);
        }
        IJsonUtil.toJson(newMap);

        List<Map<String, Object>> ll = jdbcTemplate.queryForList("select table_name from user_tables");

        for (Map<String, Object> row : ll) {
            String table = ((String) row.get("table_name")).toLowerCase();
            if (newMap.containsKey(table)) {
                renameBaseDB(table, newMap);
            }
        }

        System.out.println(IJsonUtil.toJson(alltables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(tables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(errortables));
    }

    public void renameBaseDB(String table, Map<String, String> newMap) {
        table = table.toLowerCase();
        alltables.add(table);

        String newtable = newMap.get(table);
        String sql = " alter table " + table + " rename to " + newtable;
        try {
            jdbcTemplate.execute(sql);
            tables.put(table, newtable);
        } catch (Exception e) {
            errortables.add(table);
        }
    }

    private static Set<String> alltables = new HashSet<>();
    private static Set<String> errortables = new HashSet<>();
    private static Map<String, String> tables = new HashMap<>();

    private static Set<String> ssc_need_tables = new HashSet<>();
    private static Set<String> ssc_tables = new HashSet<>();


    static {
        String[] sntable = TablesDefine1.sscneedtable.split(";");

        for (String t : sntable) {
            ssc_need_tables.add(t.toLowerCase());
        }

        String stable[] = TablesDefine1.ssctable.split(";");
        for (String t : stable) {
            ssc_tables.add(t.toLowerCase());
        }


    }

    private static String pifx = "_s_";

    public void renameSSCDB(String table) {
        table = table.toLowerCase();
        alltables.add(table);
        if (!ssc_tables.contains(table) &&
                !ssc_need_tables.contains(table) &&
                !table.startsWith("saga") &&
                !table.startsWith("opm") &&
                !table.startsWith("tm_") &&
                !table.startsWith("fw_") &&
                !table.startsWith("sscpfa")) {
            String newtable = table + pifx;
            String sql = " alter table " + table + " rename to " + newtable;
            try {
                jdbcTemplate.execute(sql);
                tables.put(table, newtable);
            } catch (Exception e) {
                newtable = table.substring(0, table.length() - 3) + pifx;
                String sql1 = " alter table " + table + " rename to " + newtable;
                try {
                    jdbcTemplate.execute(sql1);
                    tables.put(table, newtable);
                } catch (Exception e1) {
                    try {
                        newtable = table.substring(0, table.length() - 4) + "_" + pifx;
                        String sql2 = " alter table " + table + " rename to " + newtable;
                        jdbcTemplate.execute(sql2);
                        tables.put(table, newtable);
                    } catch (Exception e2) {
                        log.info(sql1);
                        errortables.add(table);
                    }
                }
            }
        }
    }

    public void resumeSSCDB() {
        List<Map<String, Object>> ll = jdbcTemplate.queryForList("select table_name from user_tables");

        for (Map<String, Object> row : ll) {
            String table = ((String) row.get("table_name")).toLowerCase();
            alltables.add(table);
            if (table.startsWith("sscpfa") && table.endsWith("_s_")) {
                String newtable = table.replace("_s_", "");
                String sql = " alter table " + table + " rename to " + newtable;
                try {
                    jdbcTemplate.execute(sql);
                    tables.put(table, newtable);
                } catch (Exception e) {
                    errortables.add(table);
                }
            }
        }

        System.out.println(IJsonUtil.toJson(alltables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(tables));
        System.out.println("=====================================");
        System.out.println(IJsonUtil.toJson(errortables));
    }

    public void renameUAPDB(Map<String, Object> row) {
        String table = ((String) row.get("table_name")).toLowerCase();
        alltables.add(table);
        if (ssc_tables.contains(table)) {
            String newTable = table.substring(0, table.length() - 3) + pifx;
            String sql = " alter table " + table + " rename to " + newTable;
            try {
                jdbcTemplate.execute(sql);
                tables.put(table, newTable);
            } catch (Exception e) {
                try {
                    newTable = table + pifx;
                    String sql1 = " alter table " + table + " rename to " + table + pifx;
                    jdbcTemplate.execute(sql1);
                    tables.put(table, newTable);
                } catch (Exception e1) {
                    errortables.add(table);
                }
            }
        }
    }

    public void testSSCDB() {

        List<Map<String, Object>> ll = jdbcTemplate.queryForList("select table_name from user_tables");

        Set<String> readyTables = new HashSet<>();
        for (Map<String, Object> row : ll) {
            String table = ((String) row.get("table_name")).toLowerCase();
            readyTables.add(table);
        }

        Set<String> notReadyTables = new HashSet<>();

        for (String table : ssc_need_tables) {
            if (!readyTables.contains(table)) {
                notReadyTables.add(table);
            }
        }

        for (String table : ssc_tables) {
            if (!readyTables.contains(table)) {
                notReadyTables.add(table);
            }
        }

        System.out.println(IJsonUtil.toJson(notReadyTables));
    }


    public void buildSSCDBSql() {

        StringBuilder s = new StringBuilder();
        int i = 0;
        for (String table : ssc_need_tables) {
            if (i > 0) {
                s.append(",");
                i++;
            }
            s.append("'" + table + "'");
        }
        for (String table : ssc_tables) {
            s.append(",'" + table + "'");
        }

    }
}

