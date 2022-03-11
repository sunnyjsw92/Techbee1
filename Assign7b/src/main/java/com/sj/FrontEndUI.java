package com.sj;

import java.sql.SQLException;
import java.util.Scanner;

public class FrontEndUI {
    static String firstName;
    static String lastName;
    static String phoneNumber;
    static String emailAddress;
    static String userName;
    static int age;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        Scanner scan = new Scanner(System.in);


        System.out.println(
                "what would you like to do today - new user - enter 1; update - enter " + "2; delete " + "-3, get user info -4 ");
        int action = scan.nextInt();

        if (action == 1) {
            User user = new User();
            user = userAdd(action, user);
            UserDAO.addUser(user);
            scan.close();
        }
        if (action == 2) {
            User user = getUser();
            if (user == null) {
                System.out.println("this user does not exists");
            } else
        {
                System.out.println("please update the info for the user");
                user = userAdd(action, user);
                UserDAO.updateUser(user);
            }
        }
        if (action == 3) {
            User user = getUser();
            if (user.getUserName() == null || user.getFirstName().equals(null)) {
                System.out.println("this user does not exists");
            } else {
                UserDAO.delUser(user);
            }
        }
        if (action == 4) {
            User user = getUser();
            if (user.getUserName() == null || user.getFirstName().equals(null)) {
                System.out.println("this user does not exists");
            } else {
                System.out.println("here is the information for User with username - " + user.getUserName());
                System.out.println(
                        user.getFirstName() + " " + user.getLastName() + " " + user.getEmailAddress() + " " + user.getPhoneNumber() + " " + user.getAge());
            }
        }
        scan.close();
    }

    public static User userAdd(Integer action, User user) {
        Scanner scan2 = new Scanner(System.in);
        boolean flag2 = false;
        while (!flag2) {
            System.out.println("Please input firstname - only characters and less than 24 chars");
            firstName = scan2.nextLine();
            flag2 = Validator.nameCheck(firstName);
        }
        user.setFirstName(firstName);

        flag2 = false;
        while (!flag2) {
            System.out.println("Please input lastname - only characters and less than 24 chars");
            lastName = scan2.nextLine();
            flag2 = Validator.nameCheck(lastName);
        }
        user.setLastName(lastName);

        flag2 = false;
        while (!flag2) {
            System.out.println("Please input phone number - XXX-XXX-XXXX format");
            phoneNumber = scan2.nextLine();
            flag2 = Validator.phoneCheck(phoneNumber);
        }
        user.setPhoneNumber(phoneNumber);

        flag2 = false;
        while (!flag2) {
            System.out.println("Please input email address ");
            emailAddress = scan2.nextLine();
            flag2 = Validator.emailCheck(emailAddress);
        }
        user.setEmailAddress(emailAddress);
        flag2 = action == 2;
        while (!flag2) {
            System.out.println("Please input username - only characters and less than 24 chars ");
            userName = scan2.nextLine();
            flag2 = Validator.nameCheck(userName);
        }
        if (action == 1)
            user.setUserName(userName);

        flag2 = false;
        while (!flag2) {
            System.out.println("Please input your age");
            age = scan2.nextInt();
            flag2 = Validator.ageCheck(age);
        }
        user.setAge(age);
        scan2.close();
        return user;
    }

    public static User getUser() throws SQLException, ClassNotFoundException {
        boolean flag3 = false;
        Scanner scan3 = new Scanner(System.in);
        while (!flag3) {
            System.out.println("Please input username ");
            userName = scan3.nextLine();
            flag3 = Validator.nameCheck(userName);
        }
        return UserDAO.getUser(userName);
    }
}
