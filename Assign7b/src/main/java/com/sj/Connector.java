package com.sj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String Url = "jdbc:mysql://db1.cxrelewsmscc.us-west-1.rds" + ".amazonaws.com:3306/db1";
    private static String jdbcUserName = "admin";
    private static String jdbcPassword = "admin123";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(Url, jdbcUserName, jdbcPassword);
        return connection;
    }
}
