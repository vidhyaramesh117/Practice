package com.example.apiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.SortedList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class update extends AppCompatActivity
{
    String url = "https://reqres.in/";

    EditText name_et,qualification_et;
    Button button;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_et = findViewById(R.id.name);
        qualification_et = findViewById(R.id.qualification);
        button = findViewById(R.id.post_submit);
        textView = findViewById(R.id.response_tv);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view1)
            {
                if (TextUtils.isEmpty(name_et.getText().toString()) && TextUtils.isEmpty(qualification_et.getText().toString()))
                {
                    Toast.makeText(getApplication(), "Enter your data", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    update_data_method(name_et.getText().toString(),qualification_et.getText().toString());
                }
            }
        });
    }

    private void update_data_method(String name, String qualification)
    {
        Retrofit retrofit_update = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        retrofit_api_update retrofit_api_update1 = retrofit_update.create(retrofit_api_update.class);
        data_modal_update modal = new data_modal_update(name,qualification);

        Call<data_modal_update> call = retrofit_api_update1.updateData(modal);
        call.enqueue(new Callback<data_modal_update>() {
            @Override
            public void onResponse(Call<data_modal_update> call, Response<data_modal_update> response)
            {
                Toast.makeText(getApplication(), "Data updated in API", Toast.LENGTH_SHORT).show();

                name_et.setText(" ");
                qualification_et.setText(" ");

                data_modal_update response_from_API = response.body();

                String response_string = "Response code: "+  response.code() + "\n Name :" +response_from_API.getName() + "\n Qualification: " +response_from_API.getQualification();
                textView.setText(response_string);

            }

            @Override
            public void onFailure(Call<data_modal_update> call, Throwable t)
            {
                textView.setText("Error is " + t.getMessage());
            }
        });
    }
}