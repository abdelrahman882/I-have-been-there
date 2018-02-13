package com.example.android.stadiumsmapapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ahmed on 2/11/2018.
 */

public class EventAdapter extends ArrayAdapter<Event> {
    ArrayList<Event> myEvents;

    public EventAdapter(@NonNull Context context, ArrayList<Event> myEvents) {
        super(context, 0, myEvents);
        this.myEvents = myEvents;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View x = convertView;
        if (x == null) {
            x = LayoutInflater.from(getContext()).inflate(
                    R.layout.event, parent, false);
        }
        Event event = myEvents.get(position);
        HashMap  <String,String> properties= event.getProperties();

        ImageView logo = (ImageView) x.findViewById(R.id.league_logo);
        logo.setImageResource(Integer.valueOf(properties.get("leagueLogo")));

        ImageView firstTeamLogo = (ImageView) x.findViewById(R.id.FirstTeamLogo);
        firstTeamLogo.setImageResource(Integer.valueOf(properties.get("1stTeamLogo")));

        ImageView secondTeamLogo = (ImageView) x.findViewById(R.id.SecontTeamLogo);
        secondTeamLogo.setImageResource(Integer.valueOf(properties.get("2ndTeamLogo")));

        TextView time = (TextView) x.findViewById(R.id.time);
        time.setText(properties.get("time"));

        TextView FirstTeam = (TextView) x.findViewById(R.id.firstTeam);
        FirstTeam.setText(properties.get("1stTeam"));

        TextView SecondTeam = (TextView) x.findViewById(R.id.SecondTeam);
        SecondTeam.setText(properties.get("2ndTeam"));

        TextView result = (TextView) x.findViewById(R.id.result);
        result.setText(properties.get("result"));


//put the vairables to the x children views

        return x;
    }

}
