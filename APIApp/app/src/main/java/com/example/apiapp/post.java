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

public class post extends AppCompatActivity
{
    EditText name_et,qualification_et;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        name_et = findViewById(R.id.name);
        qualification_et = findViewById(R.id.qualification);
        button = findViewById(R.id.post_submit);
        textView = findViewById(R.id.response_tv);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(name_et.getText().toString().isEmpty() && qualification_et.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplication(), "Enter both values", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    post_data(name_et.getText().toString(),qualification_et.getText().toString());
                }

            }

        });

    }

    private void post_data(String name, String qualification)
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/api/").addConverterFactory(GsonConverterFactory.create()).build();
        retrofit_api retrofit1 = retrofit.create(retrofit_api.class);
        data_modal modal = new data_modal(name,qualification);
        Call<data_modal> call = retrofit1.createPost(modal);

        call.enqueue(new Callback<data_modal>()
        {
            @Override
            public void onResponse(Call<data_modal> call, Response<data_modal> response)
            {
                Toast.makeText(getApplication(), "Data added to API", Toast.LENGTH_SHORT).show();

                name_et.setText("");
                qualification_et.setText("");

                data_modal response_from_api = response.body();
                String response_string = "Response code :" + response.code() + "\n Name :" + response_from_api.getName() + "\n Qualification :" + response_from_api.getQualification();
                textView.setText(response_string);
            }

            @Override
            public void onFailure(Call<data_modal> call, Throwable t)
            {
                textView.setText("Error founded " + t.getMessage());
            }
        });
    }
}