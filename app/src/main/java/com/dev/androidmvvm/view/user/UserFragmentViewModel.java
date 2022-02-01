package com.dev.androidmvvm.view.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dev.androidmvvm.model.User;
import com.dev.androidmvvm.repository.UserRepository;

import java.util.ArrayList;

public class UserFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<User>> users = new MutableLiveData<>();
    public LiveData<ArrayList<User>> usersLivedata = users;

    public void getUsers(){
        users.postValue(UserRepository.getInstance().getUsers());
    }

    public void addUser(User user){
        UserRepository.getInstance().addUser(user);
        getUsers();
    }

    public void deleteUser(User user){
        UserRepository.getInstance().deleteUser(user);
        getUsers();
    }
}
