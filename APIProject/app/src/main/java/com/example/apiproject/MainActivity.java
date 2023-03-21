package com.example.apiproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        getSuperHeroes();


    }

    private void getSuperHeroes() {
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