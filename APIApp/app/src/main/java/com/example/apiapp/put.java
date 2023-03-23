package com.example.apiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class put extends AppCompatActivity
{

    EditText name_et,qualification_et;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        name_et = findViewById(R.id.name);
        qualification_et = findViewById(R.id.qualification);
        button = findViewById(R.id.post_submit);
        textView = findViewById(R.id.response_tv);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (name_et.getText().toString().isEmpty() && qualification_et.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplication(), "Enter both values", Toast.LENGTH_SHORT).show();

                } else
                {
                    put_data(name_et.getText().toString(), qualification_et.getText().toString());
                }

            }

        });

    }

    private void put_data(String name, String qualification)
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/api/") .addConverterFactory(GsonConverterFactory.create()).build();
        retrofit_api_put retrofit_api_put1 = retrofit.create(retrofit_api_put.class);
        data_modal_put modal = new data_modal_put(name,qualification);
        Call<data_modal_put> call = retrofit_api_put1.putData(modal);

        call.enqueue(new Callback<data_modal_put>() {
            @Override
            public void onResponse(Call<data_modal_put> call, Response<data_modal_put> response)
            {
                Toast.makeText(getApplication(), "Data put to API", Toast.LENGTH_SHORT).show();
                name_et.setText(" ");
                qualification_et.setText(" ");

                data_modal_put response_from_API = response.body();

                String response_String = "Response Code : " + response.code() + "\n Name:" + response_from_API.getName() + "\nQualification: "  +response_from_API.getQualification();
                textView.setText(response_String);
            }

            @Override
            public void onFailure(Call<data_modal_put> call, Throwable t)
            {
                textView.setText("Error found is " + t.getMessage());
            }
        });
    }
}