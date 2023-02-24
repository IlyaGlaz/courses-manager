package org.team24.coursesmanager;

import java.util.ArrayList;
import java.util.List;
public class MainRandom {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User("Ilia", "Glass"));
        userList.add(new User("Sergey", "Bernikov"));
        userList.add(new User("Pavel", "Bal"));
        userList.add(new User("Sergey", "Kurinkov"));
        userList.add(new User("Bob", "American"));

        List<String> newListAfterRandom = RandomUser.randomUser(userList);

        System.out.println(newListAfterRandom);
    }
}