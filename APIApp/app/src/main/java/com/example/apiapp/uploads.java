package com.example.apiapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.net.DatagramPacket;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

            File image_file = new File(String.valueOf(real_uri));
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),image_file);
            MultipartBody.Part image = MultipartBody.Part.createFormData("image",image_file.getName(),requestBody);
            Call<Response_Pojo> call = submit.submit_data(image,"pawneshwergupta@gmail.com","learnpainless.com");

            call.enqueue(new Callback<Response_Pojo>()
            {
                @Override
                public void onResponse(Call<Response_Pojo> call, Response<Response_Pojo> response)
                {
                    Response_Pojo body = response.body();

                    AlertDialog.Builder alert = new AlertDialog.Builder(uploads.this);
                    alert.setMessage(body.getMessage());
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                        }

                    });
                    alert.show();
                }

                @Override
                public void onFailure(Call<Response_Pojo> call, Throwable t)
                {

                }
            });


        }
    });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            image.setImageURI(data.getData());
            try
            {
                real_uri = Uri.parse(getRealPathFromURI(data.getData()));
                Log.d(TAG,"Image path : "+real_uri);
                Log.d(TAG,"Image uploaded successfully");
//                AlertDialog.Builder alert = new AlertDialog.Builder(uploads.this);
//                alert.setMessage("Image path : "+real_uri); //display response in Alert dialog.
//                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                alert.show();

            }
            catch (Exception e)
            {
                Log.e(TAG,e.getMessage());
            }
        }
    }

    private String getRealPathFromURI(Uri content_URI)
    {
        String res = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(content_URI,proj,null,null,null);
        assert cursor != null;
        if (cursor.moveToFirst())
        {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


}