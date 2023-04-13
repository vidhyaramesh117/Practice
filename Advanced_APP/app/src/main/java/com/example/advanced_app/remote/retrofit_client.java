package com.example.advanced_app.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_client
{

    private static Retrofit retrofit = null;
    public static Retrofit get_client(String url)
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
