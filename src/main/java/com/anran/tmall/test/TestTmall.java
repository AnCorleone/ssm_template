package com.anran.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/14
 * @time 15:13
 * 描述    ${TODO}
 */
public class TestTmall {

    private static String url ="jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String userName = "root";
    private static String password = "1234";
    private static Statement connectionStatement;

    public static void main(String args[]) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            connectionStatement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <10 ; i++) {
            String sqlFormat = "insert into category values (null, '测试分类%d')";
            String sql = String.format(sqlFormat, i);
            try {
                connectionStatement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("已经成功创建10条分类测试数据");

    }
}
