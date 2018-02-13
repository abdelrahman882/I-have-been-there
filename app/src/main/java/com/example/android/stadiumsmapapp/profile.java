package com.example.android.stadiumsmapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        Spinner x= (Spinner)findViewById(R.id.favTeam);
        String[] teams = new String[]{"Alahly", "Zamaleck", "al Wydad"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, teams);
        x.setAdapter(adapter);
    }
}
