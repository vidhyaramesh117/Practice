package com.example.apiapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface retrofit_api
{
    @POST("users")
    Call<data_modal> createPost(@Body data_modal data_modal);
}




