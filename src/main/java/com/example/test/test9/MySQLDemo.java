package com.example.test.test9;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : baifuquan
 * @date : 2022/11/16 22:05
 * @className : MySQLDemo
 * @description : MySQLDemo
 **/
public class MySQLDemo {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mytest";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String[] args) {

    }

    @Test
    public void testConnMysql() {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT *,DATE_FORMAT(create_time,'%Y-%m-%d %h:%i:%s') as create_time FROM t_comment";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            List<Map<String,String>> mapList = new ArrayList<>();

            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                int p_id  = rs.getInt("p_id");
                int u_id  = rs.getInt("u_id");
                String u_name = rs.getString("u_name");
                String u_rel_name = rs.getString("u_rel_name");
                String u_dept = rs.getString("u_dept");
                String comment = rs.getString("comment");
                String create_time = rs.getString("create_time");
                HashMap hm = new HashMap();
                hm.put("id",String.valueOf(id));
                hm.put("p_id",String.valueOf(p_id));
                hm.put("u_id",String.valueOf(u_id));
                hm.put("u_name",u_name);
                hm.put("u_rel_name",u_rel_name);
                hm.put("u_dept",u_dept);
                hm.put("comment",comment);
                hm.put("create_time",create_time);
                mapList.add(hm);
                // 输出数据
//                System.out.println("id: " + id);
//                System.out.println("p_id: " + p_id);
//                System.out.println("u_id: " + u_id);
//                System.out.println("u_name: " + u_name);
//                System.out.println("u_rel_name: " + u_rel_name);
//                System.out.println("u_dept: " + u_dept);
//                System.out.println("comment: " + comment);
//                System.out.println("create_time: " + create_time);

            }
            System.out.println(JSONUtil.toJsonStr(mapList));
            List<Map<String,String>> mapList1 = new ArrayList<>();

            for(int i=0 ;i < mapList.size();i++) {

            }

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }// 处理 Class.forName 错误
        finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException ignored){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
