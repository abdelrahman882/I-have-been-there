package com.example.android.stadiumsmapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        getSupportActionBar().hide();
        ArrayList<Event> event = new ArrayList<Event>();
        HashMap<String, String> properties = new HashMap<>();
        properties.put("leagueLogo", String.valueOf(R.drawable.logo));
        properties.put("1stTeamLogo", String.valueOf(R.drawable.teamlogo));
        properties.put("2ndTeamLogo", String.valueOf(R.drawable.teamlogo));
        properties.put("time", "Today, 6pm");
        properties.put("1stTeam", "Zamaleck");
        properties.put("2ndTeam", "Al Widad");
        properties.put("result", "0  -   0");
        Event x = new Event(properties);
        for (int i = 0; i < 10; i++)
            event.add(x);
        EventAdapter itemsAdapter = new EventAdapter(this, event);
        ListView listView = (ListView) findViewById(R.id.eventsList);
        listView.setAdapter(itemsAdapter);

    }
    public void viewProfile(View view)
    {
        Intent x=new Intent(this,profile.class);
        startActivity(x);
    }
    public void EditProfile(View view)
    {
        Intent x=new Intent(this,profile.class);
        startActivity(x);
    }

}
