package com.example.advanced_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button validation,web_api,q_r_code,notification;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validation = findViewById(R.id.validation_btn);
        web_api = findViewById(R.id.web_api_btn);
        q_r_code = findViewById(R.id.q_r_code_btn);
        notification = findViewById(R.id.notification_btn);

        validation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),validations.class);
                startActivity(intent);
            }
        });

        web_api.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),validations.class);
                startActivity(intent);
            }
        });

        q_r_code.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),q_r_code.class);
                startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),notification.class);
                startActivity(intent);
            }
        });
    }
}