package com.sj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static void addUser(User user) throws SQLException, ClassNotFoundException {
        String insert =
                "INSERT INTO  Table1 (firstName, lastName, phoneNumber, emailAddress, " + "userName, age) "
                        + "VALUES (?, ?, " + "?, ?, ?, ?)";
        Connection connection = Connector.getConnection();
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getPhoneNumber());
        ps.setString(4, user.getEmailAddress());
        ps.setString(5, user.getUserName());
        ps.setInt(6, user.getAge());
        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("successfully added user in the database");
        }
    }

    public static void updateUser(User user) throws SQLException, ClassNotFoundException {
        String update = "UPDATE Table1 SET firstName = ?, lastName = ?, phoneNumber = ?, emailAddress = ?, "
                + "userName = ?, age = ? WHERE username = ?";
        Connection connection = Connector.getConnection();
        PreparedStatement ps = connection.prepareStatement(update);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getPhoneNumber());
        ps.setString(4, user.getEmailAddress());
        ps.setString(5, user.getUserName());
        ps.setInt(6, user.getAge());
        ps.setString(7, user.getUserName());
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("successfully updated user in database");
        }
    }

    public static User getUser(String userName) throws SQLException, ClassNotFoundException {
        String get =
                "SELECT firstName, lastName, phoneNumber, emailAddress, userName, age from Table1  WHERE userName = ?";
        Connection connection = Connector.getConnection();
        PreparedStatement ps = connection.prepareStatement(get);
        ps.setString(1, userName);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("user not found"); return null;
        }
        User user = new User();
        while (rs.next()) {
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setEmailAddress(rs.getString("emailAddress"));
            user.setUserName(userName);
            user.setAge(rs.getInt("age"));
        }
        return user;
    }

    public static void delUser(User user) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM Table1 WHERE userName = ?";
        Connection connection = Connector.getConnection();
        PreparedStatement ps = connection.prepareStatement(delete);
        ps.setString(1, user.getUserName());
        int deleted = ps.executeUpdate();
        if (deleted > 0) {
            System.out.println("successfully deleted user");
        }

    }
}
