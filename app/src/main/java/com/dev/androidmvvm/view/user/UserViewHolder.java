package com.dev.androidmvvm.view.user;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.androidmvvm.R;
import com.dev.androidmvvm.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private AppCompatTextView emailTV;
    private AppCompatTextView nameTV;
    private AppCompatButton deleteButton;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        emailTV = itemView.findViewById(R.id.emailTV);
        nameTV = itemView.findViewById(R.id.nameTV);
        deleteButton = itemView.findViewById(R.id.deleteBtn);
    }

    public void bind(User user, UserAdapter.UserAdapterInterface userAdapterInterface){
        nameTV.setText(user.getName());
        emailTV.setText(user.getEmail());
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAdapterInterface.onDelete(user);
            }
        });
    }
}
