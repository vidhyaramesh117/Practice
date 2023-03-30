package com.example.apiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button post,update,put;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        post = findViewById(R.id.post_btn);
        update = findViewById(R.id.update_btn);

        post.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),post.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view1)
            {
                Intent intent1 = new Intent(getApplicationContext(),update.class);
                startActivity(intent1);
            }
        });


    }
}