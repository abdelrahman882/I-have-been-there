package com.example.ahmednasser.myapplication;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.util.UUID;

/**
 * Created by ahmednasser on 1/31/18.
 */

public class Preview extends AppCompatActivity {
    private Uri filePath;
    private Bitmap holdBitmap;
    private final int PICK_IMAGE_REQUEST = 71;
    private FirebaseStorage mFirebaseStorage;
    private StorageReference mChatPhotosStorageReference;
    public Bitmap getHoldBitmap() {
        return holdBitmap;
    }

    public String getHoldDesciption() {
        return holdDesciption;
    }

    private String holdDesciption ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);
        mFirebaseStorage = FirebaseStorage.getInstance();
        mChatPhotosStorageReference = mFirebaseStorage.getReference().child("photos");
        Main3Activity x = new Main3Activity();
        holdBitmap=x.ImageDrawable;
        holdDesciption= getIntent().getStringExtra("describtion");
        filePath = x.ImageCaptureUri;
        Log.v("Uri",filePath+"");
        TextView preDescribtion = (TextView) findViewById(R.id.predescribtion);
        preDescribtion.setText(holdDesciption);
        ImageView preimage = (ImageView) findViewById(R.id.preimagepost);
        preimage.setImageBitmap(holdBitmap);



    }

    public void Post(View view) {

       // UploadToDrive c = new UploadToDrive(holdBitmap);
        //    Toast.makeText(Preview.this, "Lsa Ya Ahbal", Toast.LENGTH_LONG).show();


        StorageReference photoRef = mChatPhotosStorageReference.child(filePath.getLastPathSegment());

        // Upload file to Firebase Storage
        photoRef.putFile(filePath)
                .addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // When the image has successfully uploaded, we get its download URL
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
Log.v("urlphoto",downloadUrl.toString());
Toast.makeText(Preview.this,"PhotoUrl: "+downloadUrl.toString(),Toast.LENGTH_LONG).show();
                        // Set the download URL to the message box, so that the user can send it to the database

                    }
                });
        }
    }



