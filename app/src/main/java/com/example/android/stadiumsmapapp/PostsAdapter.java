package com.example.android.stadiumsmapapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Ahmed on 2/12/2018.
 */

public class PostsAdapter extends ArrayAdapter<Post> {
    ArrayList<Post> myPosts;

    public PostsAdapter(@NonNull Context context, ArrayList<Post> myposts) {
        super(context, 0, myposts);
        this.myPosts = myposts;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View x = convertView;
        if (x == null) {
            x = LayoutInflater.from(getContext()).inflate(
                    R.layout.event, parent, false);
        }

        //
        //
        //put stuff here
        //
        //

        return  x;
    }
}
