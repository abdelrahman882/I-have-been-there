package com.example.android.stadiumsmapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class Event {
    private HashMap<String,String> properties = new HashMap();

   public Event( HashMap<String,String> properties)
   {
       this.properties= properties;
   }
   public HashMap<String,String> getProperties()
   {
       return properties;
   }
}
