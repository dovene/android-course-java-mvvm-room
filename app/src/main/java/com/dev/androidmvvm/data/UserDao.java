package com.dev.androidmvvm.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.dev.androidmvvm.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getUsers();

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);
}
