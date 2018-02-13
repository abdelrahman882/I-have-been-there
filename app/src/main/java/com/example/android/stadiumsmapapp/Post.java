package com.example.android.stadiumsmapapp;

import java.util.HashMap;

/**
 * Created by Ahmed on 2/12/2018.
 */

public class Post {
    private HashMap<String,String> properties = new HashMap();

    public Post( HashMap<String,String> properties)
    {
        this.properties= properties;
    }
    public HashMap<String,String> getProperties()
    {
        return properties;
    }
}
