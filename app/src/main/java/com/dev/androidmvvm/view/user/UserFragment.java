package com.dev.androidmvvm.view.user;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.androidmvvm.R;
import com.dev.androidmvvm.model.User;
import com.dev.androidmvvm.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private AppCompatButton addButton;
    private AppCompatEditText emailEdit;
    private AppCompatEditText nameEdit;
    private  UserFragmentViewModel viewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(UserFragmentViewModel.class);

    }

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

        userAdapter = new UserAdapter(new UserAdapter.UserAdapterInterface() {
            @Override
            public void onDelete(User user) {
                viewModel.deleteUser(user, getContext());
            }
        });
        recyclerView.setAdapter(userAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addUser(new User(emailEdit.getText().toString(), nameEdit.getText().toString()), getContext());
            }
        });

        viewModel.getUsers(getContext()).observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter.setUsers(new ArrayList<>(users));
            }
        });

    }
}
