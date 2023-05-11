package com.example.test.test7;
import org.junit.Test;

import java.sql.*;

/**
 * @author : baifuquan
 * @date : 2022/10/10 00:50
 * @className : Test9
 * @description : Test9
 **/
public class Test9 {

    public static void main(String[] args) {
    }

    @Test
    public  void test11() {
        try {
            Connection conn = getConnection();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            String sql = "select * from t1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=utf-8","root", "12345678");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**

     * 关闭连接

     * @param conn

     * @param prep

     * @param rs

     */

    public static void close(Connection conn,PreparedStatement prep,ResultSet rs){

        if(rs != null){

            try {

                rs.close();

            } catch (SQLException e) {

                e.printStackTrace();

            } finally{
                rs = null;
            }
        }
        if(prep != null){
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                prep = null;
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                conn = null;
            }
        }
    }
}
