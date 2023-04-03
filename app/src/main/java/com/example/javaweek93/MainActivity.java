package com.example.javaweek93;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserStorage s = UserStorage.getInstance();

        context = MainActivity.this;
        s.loadUser(context);

    }

    public void switchToUserList(View view) {
        Intent intent = new Intent(this, userListActicity.class);
        startActivity(intent);
    }


    public void switchToUserAdd(View view) {
        Intent intent = new Intent(this, addUserActivity.class);
        startActivity(intent);
    }




}