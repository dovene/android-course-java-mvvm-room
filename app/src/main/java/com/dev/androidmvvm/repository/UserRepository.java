package com.dev.androidmvvm.repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.dev.androidmvvm.data.AppDatabase;
import com.dev.androidmvvm.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

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

    public void addUser(User user, Context context) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase.getInstance(context).getUserDao().insertUser(user);
            }
        });
    }

    public void deleteUser(User user, Context context) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase.getInstance(context).getUserDao().deleteUser(user);
            }
        });

    }

    public LiveData<List<User>> getUsers(Context context) {
        return AppDatabase.getInstance(context).getUserDao().getUsers();
    }

}
