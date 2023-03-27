package com.example.javaweek93;

import java.util.ArrayList;

public class UserStorage {

    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage storage = null;

    private UserStorage(){
    }

    public static UserStorage getInstance(){
        if (storage == null){
            storage = new UserStorage();
        }
        return storage;
    }


    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

}
