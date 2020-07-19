package com.servi.study.db._02_sqlparser;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleSchemaStatVisitor;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

/**
 * @author servi
 * @date 2020/7/17
 */
public class T01_SelectSQL {

    public static void main(String[] args) throws SQLSyntaxErrorException {
        String sql = "select next_run_date, obj#, run_job, sch_job from (select decode(bitand(a.flags, 16384), 0, a.next_run_date,                a.last_enabled_time) next_run_date,       a.obj# obj#, decode(bitand(a.flags, 16384), 0, 0, 1) run_job, a.sch_job  sch_job  from  (select p.obj# obj#, p.flags flags, p.next_run_date next_run_date,      p.job_status job_status, p.class_oid class_oid,      p.last_enabled_time last_enabled_time, p.instance_id instance_id,      1 sch_job   from sys.scheduler$_job p   where bitand(p.job_status, 3) = 1    and ((bitand(p.flags, 134217728 + 268435456) = 0) or         (bitand(p.job_status, 1024) <> 0))    and bitand(p.flags, 4096) = 0    and p.instance_id is NULL    and (p.class_oid is null      or (p.class_oid is not null      and p.class_oid in (select b.obj# from sys.scheduler$_class b                          where b.affinity is null)))   UNION ALL   select q.obj#, q.flags, q.next_run_date, q.job_status, q.class_oid,      q.last_enabled_time, q.instance_id, 1   from sy";
        //String sql = "SELECT count ( b.PK_MESSAGE ) FROM ( select PK_MESSAGE from sm_msg_approve a WHERE a.msgtype = 'nc' AND a.pk_message IN ( SELECT pk_message FROM sm_msg_user WHERE sm_msg_user.isdelete = 'N' AND sm_msg_user.isread = 'N' AND sm_msg_user.destination = 'inbox' AND sm_msg_user.message_type = 'approve' AND sm_msg_user.pk_user = '0001A5100000000009A4' ) ) b";
      //  String sql = "insert into tmpbd_accassqry ( pk_accasoa, pk_account ) select pk_accasoahistory, pk_account from bd_accasoahistory where pk_accasoa in ( 'null' ) and pk_accchart in ( select pk_accchart from bd_accchart where ( beginperiod <= '2020-07-13' and endperiod > '2020-07-13' ) )";
        String dbType = "oracle";
        System.out.println("原始SQL 为 ： " + sql);
        SQLSelectStatement statement = (SQLSelectStatement) parser(sql, dbType);
        //SQLInsertStatement statement = (SQLInsertStatement) parser(sql, dbType);
//      MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        OracleSchemaStatVisitor visitor = new OracleSchemaStatVisitor();
        statement.accept(visitor);

        System.out.println(visitor.getTables().toString());
    }

    public static SQLStatement parser(String sql, String dbType) throws SQLSyntaxErrorException {
        List<SQLStatement> list = SQLUtils.parseStatements(sql, dbType);
        if (list.size() > 1) {
            throw new SQLSyntaxErrorException("MultiQueries is not supported,use single query instead ");
        }
        return list.get(0);
    }
}
