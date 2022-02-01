package com.dev.androidmvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dev.androidmvvm.R;
import com.dev.androidmvvm.view.user.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.container, new UserFragment())
                    .commit();
        }
    }

}