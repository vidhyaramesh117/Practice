package com.example.advanced_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class validations extends AppCompatActivity
{

    private EditText name_et,job_et,email_et,password_et;
    private Button proceed_btn,cancel_btn;
    boolean is_all_fields_checked = false;
    String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validations);

        name_et = findViewById(R.id.name);
        job_et = findViewById(R.id.job);
        email_et = findViewById(R.id.email);
        password_et = findViewById(R.id.password);
        proceed_btn = findViewById(R.id.btn_proceed);
        cancel_btn = findViewById(R.id.btn_cancel);

        proceed_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                is_all_fields_checked = checked_all_fields();
                if (is_all_fields_checked)
                {
                    Intent intent = new Intent(getApplication(),valid_proceed_page.class);
                    startActivity(intent);
                }
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validations.this.finish();
                System.exit(0);
            }
        });

    }

    private boolean checked_all_fields()
    {
        if (name_et.length() == 0)
        {
            name_et.setError("Name is required");
            return false;
        }
        if (job_et.length() == 0)
        {
            job_et.setError("Job is required");
            return false;
        }
        if (email_et.length() == 0)
        {
            email_et.setError("Email is required");
            return false;
        }
        else if (!email_et.getText().toString().trim().matches(email_pattern))
        {
            email_et.setError("Email should be valid");
            return false;
        }
        if (password_et.length() == 0)
        {
            password_et.setError("Password is required");
            return false;
        }
        else if (password_et.length() < 5)
        {
            password_et.setError("Password must be atleast 5 characters");
            return false;
        }
        return true;
    }

}