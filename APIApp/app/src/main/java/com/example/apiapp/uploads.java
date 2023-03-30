package com.example.apiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class uploads extends AppCompatActivity
{

    String ROOT_URL = "http://192.168.1.105/learnpainless/android/";

    public static final int GALLERY_REQUEST_CODE =10;

    private String TAG = uploads.class.getSimpleName();
    private ImageView image;
    private Button btn_img,btn_upload;
    private Uri real_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads);

        image = findViewById(R.id.image);
        btn_img = findViewById(R.id.img_btn);
        btn_upload = findViewById(R.id.upload_btn);

        btn_img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent open_gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(open_gallery,"Open Gallery"),GALLERY_REQUEST_CODE);
            }
        });

    btn_upload.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Retrofit builder = new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
            Submite_API submit = builder.create(Submite_API.class);

            


        }
    });



    }
}