package com.example.ahmednasser.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main3Activity extends AppCompatActivity {
   private EditText getUrl ;
    private ImageView showImage ;
    public  static Bitmap ImageDrawable ;
    public static String ImageCapturePath ;
    public static Uri ImageCaptureUri ;

    private final static int CAMERA_PIC_REQUEST = 1337;
    //mysql7002.site4now.net

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getUrl = (EditText) findViewById(R.id.UrlEnter);
        showImage = (ImageView) findViewById(R.id.ImageView01);


    }


    public class LoadImageModule extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                ImageDrawable = BitmapFactory.decodeStream((InputStream)new URL(getUrl.getText().toString()).getContent());
                Log.v("Image",ImageDrawable+"");
                Log.v("uel",getUrl.getText().toString()+"");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null ;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            int BitmapSize =BitmapCompat.getAllocationByteCount(ImageDrawable)/1000;
            if(BitmapSize<=1024) {
                showImage.setImageBitmap(ImageDrawable);
            }else{
                Toast.makeText(Main3Activity.this, "Max Size = 1 MB", Toast.LENGTH_LONG).show();

            }
        }
    }


    public void ShowingImage(View view) {
        new LoadImageModule().execute();
    }
    public void TakingImage(View view) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        Log.v("code" , CAMERA_PIC_REQUEST+"");

        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
    }


protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == CAMERA_PIC_REQUEST) {
        Log.v("ok" , CAMERA_PIC_REQUEST+"");
            Bitmap image = (Bitmap) data.getExtras().get("data");
         //   S tring x = image
            ImageDrawable=image;
            showImage.setImageBitmap(ImageDrawable);
            String pathToImage = getLastImagePath();
         ImageCaptureUri = data.getData();
        Log.v("code" , image+"\n"+ImageDrawable+"\n"+pathToImage+"\n"+ImageCaptureUri);
         //   Uri tempUri = getImageUri(getApplicationContext(), image);
            //Log.v("Uri" , image+"\n"+tempUri);

           // File finalFile = new File(getRealPathFromURI(tempUri));
            //Log.v("File" , image+"\n"+finalFile.getPath()+"\n"+finalFile.getAbsolutePath());

            Intent postFrameIntent = new Intent(Main3Activity.this, PostFrame.class);
            Main3Activity.this.startActivity(postFrameIntent);
        }
        }

    private String getLastImagePath() {
        final String[] imageColumns = { MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DATA };
        final String imageOrderBy = MediaStore.Images.Media._ID + " DESC";
        Cursor imageCursor = this.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, imageColumns,
                null, null, imageOrderBy);
        if (imageCursor.moveToFirst()) {
            // int id = imageCursor.getInt(imageCursor
            // .getColumnIndex(MediaStore.Images.Media._ID));
            String fullPath = imageCursor.getString(imageCursor
                    .getColumnIndex(MediaStore.Images.Media.DATA));
            return fullPath;
        } else {
            return "";
        }
    }

}
