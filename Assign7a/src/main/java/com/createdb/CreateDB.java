package com.createdb;

import java.sql.SQLException;

public class CreateDB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBDao.createTable();
    }
}
