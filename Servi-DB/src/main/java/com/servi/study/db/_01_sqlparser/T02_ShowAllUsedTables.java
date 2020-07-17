package com.servi.study.db._01_sqlparser;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleSchemaStatVisitor;
import com.servi.study.json.IJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.HashSet;
import java.util.List;
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
        String sql = (String) row.get("SQL_TEXT");
        sql = sql.toLowerCase();
        try {
            if (sql.contains("insert") || sql.contains("update") || sql.contains("delete") || sql.contains("declare") || sql.contains("begin") || sql.contains("call") || sql.contains("lock table")) {

            } else {
                doParse(sql);
            }
        } catch (Exception e) {
            System.out.println(row.get("SQL_ID") + "->" + sql);
        }
    }

    public static void doParse(String sql) {
        String dbType = "oracle";
        SQLSelectStatement statement = (SQLSelectStatement) parser(sql, dbType);
        OracleSchemaStatVisitor visitor = new OracleSchemaStatVisitor();
        statement.accept(visitor);

        visitor.getTables().forEach(((name, tableStat) -> {
            if (tableStat.getSelectCount() > 0) {
                tables.add(name.getName());
            }
        }));

    }

    public static SQLStatement parser(String sql, String dbType) {
        List<SQLStatement> list = SQLUtils.parseStatements(sql, dbType);
        if (list.size() > 1) {
        }
        return list.get(0);
    }
}

