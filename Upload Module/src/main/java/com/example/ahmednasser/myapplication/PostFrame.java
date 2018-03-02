package com.example.ahmednasser.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by ahmednasser on 1/31/18.
 */

public class PostFrame extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postlayout);
      //  String bitmapData = getIntent().getStringExtra("result");
        ImageView postimage = (ImageView) findViewById(R.id.imagepost);
        Main3Activity x = new Main3Activity();
      //  Bitmap holdImage = StringToBitMap(bitmapData);
        Log.v("hello",x.ImageDrawable+"");
        postimage.setImageBitmap(x.ImageDrawable);



    }

    public void previewPost(View view) {
        EditText descArea = (EditText) findViewById(R.id.describtion);
        Intent previewFrameIntent = new Intent( PostFrame.this,Preview.class);
        previewFrameIntent.putExtra("describtion", descArea.getText().toString());
        PostFrame.this.startActivity(previewFrameIntent);
    }

   /* public Bitmap StringToBitMap(String image){
        try{
            byte [] encodeByte= Base64.decode(image,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }*/
}
