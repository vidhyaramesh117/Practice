package com.example.apiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        getSuperHeroes();

        button = findViewById(R.id.post_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplication(),post_Fragment.class);
                startActivity(intent);
            }
        });

    }

    private void getSuperHeroes()
    {
        Call<List<ResultsModal>> call = RetrofitClient.getInstance().getApi().getSuperHeroes();
        call.enqueue(new Callback<List<ResultsModal>>() {
            @Override
            public void onResponse(Call<List<ResultsModal>> call, Response<List<ResultsModal>> response) {
                List<ResultsModal> list = response.body();
                String[] heroes = new String[list.size()];
                for(int i = 0;i<list.size();i++){
                    heroes[i] = list.get(i).getSuperName();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,heroes));

            }

            @Override
            public void onFailure(Call<List<ResultsModal>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "an Error has Occured", Toast.LENGTH_SHORT).show();
            }
        });

    }

}