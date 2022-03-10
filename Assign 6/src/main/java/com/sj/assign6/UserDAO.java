package com.sj.assign6;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    static List<User> userList = new ArrayList<User>();

    public static void addUser(User user) {
        userList.add(user);
        System.out.println("user added "+userList.size());
    }

    public static void updateUser(User user) {
        int index = 0;
        int flag = 0;
        while (userList.size() > flag) {
            if (userList.get(flag).getUserName().equals(user.getUserName())) {
                index = flag;
                break;
            }
            flag=flag+1;
        }
        userList.set(index, user);
        System.out.println("user updated in dao"+ " size is "+ userList.size());
    }

    public static User getUser(String userName) {
        int flag = 0;
        while (userList.size() > flag) {
            if (userList.get(flag).getUserName().equals(userName)) {
                System.out.println("user found in DAO");
                return userList.get(flag);
            }
            flag = flag + 1;
        }
        System.out.println("user not found in DAO");
        return null;
    }

    public static void delUser(User user) {
        int index = 0;
        int flag = 0;
        while (userList.size() > flag) {
            if (userList.get(flag).getUserName().equals(user.getUserName())) {
                index = flag;
                break;
            }
        }
        userList.remove(index);
        System.out.println("user deleted in DAO"+" size is "+ userList.size());

    }
    public static void hardCoded() {
        User user6 = new User("sama", "jam", "123-456-7890", "123@gmail.com", "sama", 80);
        User user5 = new User("samb", "jam", "123-456-7890", "123@gmail.com", "samb", 70);
        User user4 = new User("samc", "jam", "123-456-7890", "123@gmail.com", "samc", 60);
        User user3 = new User("samd", "jam", "123-456-7890", "123@gmail.com", "samd", 50);
        User user2 = new User("same", "jam", "123-456-7890", "123@gmail.com", "same", 40);
        User user1 = new User("samf", "jam", "123-456-7890", "123@gmail.com", "samf", 30);
        userList.add(user1); userList.add(user2);userList.add(user3);userList.add(user4);userList.add(user5);userList.add(user6);
    }

}
