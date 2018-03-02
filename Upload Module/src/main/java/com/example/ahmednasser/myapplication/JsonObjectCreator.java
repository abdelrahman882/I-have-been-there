package com.example.ahmednasser.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ahmednasser on 2/4/18.
 */

public class JsonObjectCreator {
    JSONObject currentJsonObject = new JSONObject();
    public final static String DESC = "describtion";
    public final static String IMAGEURL = "imageUrllink";
    public String uploadedString = "";
    public JsonObjectCreator(String describtion , String PhotoURL) throws JSONException {
        currentJsonObject.put(DESC,describtion);
        currentJsonObject.put(IMAGEURL,PhotoURL);
        uploadedString = currentJsonObject.toString();

    }
}
