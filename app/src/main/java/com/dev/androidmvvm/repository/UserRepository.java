package com.dev.androidmvvm.repository;

import com.dev.androidmvvm.model.User;

import java.util.ArrayList;

public class UserRepository {

    private static UserRepository INSTANCE = null;



    private ArrayList<User> users = new ArrayList<>() ;
    private UserRepository(){
    }

    public static UserRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }
        return INSTANCE;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void deleteUser(User user){
        users.remove(user);
    }
    public ArrayList<User> getUsers() {
        return users;
    }

}
