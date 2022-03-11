package com.createdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public
class DBDao {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String userName;
    private int    age;

    public static void createTable() throws SQLException, ClassNotFoundException {
        Connection connection = Connector.getConnection();
        Statement  statement  = connection.createStatement();
        String     createDB
                              = "CREATE TABLE Table1 (userId INT(11) PRIMARY KEY "
                                + "AUTO_INCREMENT, firstName VARCHAR(24) NOT NULL, "
                                + "lastName VARCHAR(24) NOT NULL, phoneNumber VARCHAR"
                                + "(20) NOT NULL, emailAddress VARCHAR(255) NOT NULL, "
                                + "userName VARCHAR(128) NOT NULL, age INTEGER(30), "
                                + "CONSTRAINT userName UNIQUE (userName))"
                                + " ;";
        statement.execute(createDB);
        statement.close();
        connection.close();
    }


}
