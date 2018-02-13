package com.example.android.stadiumsmapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Posts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        getSupportActionBar().hide();
        ArrayList<Post> event = new ArrayList<Post>();
        HashMap<String, String> properties = new HashMap<>();
        //EventAdapter itemsAdapter = new EventAdapter(this, event);
        ListView listView = (ListView) findViewById(R.id.postsList);
        //listView.setAdapter(itemsAdapter);

    }

    public void viewProfile(View view) {
        Intent x = new Intent(this, profile.class);
        startActivity(x);
    }

    public void EditProfile(View view) {
        Intent x = new Intent(this, profile.class);
        startActivity(x);
    }
}