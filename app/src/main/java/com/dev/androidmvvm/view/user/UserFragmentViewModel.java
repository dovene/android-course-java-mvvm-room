package com.dev.androidmvvm.view.user;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev.androidmvvm.model.User;
import com.dev.androidmvvm.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserFragmentViewModel extends ViewModel {

    public LiveData<List<User>> getUsers(Context context){
        return UserRepository.getInstance().getUsers(context);
    }

    public void addUser(User user, Context context){
        UserRepository.getInstance().addUser(user, context);
    }

    public void deleteUser(User user, Context context){
        UserRepository.getInstance().deleteUser(user, context);
    }
}
