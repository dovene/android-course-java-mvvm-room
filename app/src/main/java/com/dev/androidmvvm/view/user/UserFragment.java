package com.dev.androidmvvm.view.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.androidmvvm.R;
import com.dev.androidmvvm.model.User;
import com.dev.androidmvvm.repository.UserRepository;


public class UserFragment extends Fragment {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private AppCompatButton addButton;
    private AppCompatEditText emailEdit;
    private AppCompatEditText nameEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        setViewItems(view);
        return view;
    }

    private void setViewItems(View view) {
        recyclerView = view.findViewById(R.id.recycler);
        addButton = view.findViewById(R.id.addBtn);
        emailEdit = view.findViewById(R.id.emailEdit);
        nameEdit = view.findViewById(R.id.nameEdit);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
        userAdapter = new UserAdapter(UserRepository.getInstance().getUsers(), new UserAdapter.UserAdapterInterface() {
            @Override
            public void onDelete(User user) {
                UserRepository.getInstance().deleteUser(user);
                userAdapter.setUsers(UserRepository.getInstance().getUsers());
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRepository.getInstance().addUser(new User(emailEdit.getText().toString(), nameEdit.getText().toString()));
                userAdapter.setUsers(UserRepository.getInstance().getUsers());
            }
        });
        recyclerView.setAdapter(userAdapter);
    }
}
