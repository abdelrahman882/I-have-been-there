package com.example.android.stadiumsmapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);
        Intent x= new Intent(this,Event.class);
    }
    public void guestLogIn(View view)
    {
        Intent x=new Intent(this,Events.class);
        startActivity(x);
    }
    public void logInWithFacebook(View view)
    {
        Intent x=new Intent(this,Posts.class);
        startActivity(x);
    }
}
