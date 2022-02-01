package com.dev.androidmvvm.view.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.androidmvvm.R;
import com.dev.androidmvvm.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{


    interface UserAdapterInterface {
        void onDelete(User user);
    }
    private ArrayList<User> users;
    private UserAdapterInterface userAdapterInterface;

    public UserAdapter(UserAdapterInterface userAdapterInterface){
        this.userAdapterInterface = userAdapterInterface;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_view_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(users.get(position), userAdapterInterface);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}