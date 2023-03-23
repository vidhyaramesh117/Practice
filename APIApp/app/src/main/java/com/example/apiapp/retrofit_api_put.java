package com.example.apiapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface retrofit_api_put
{
    @PUT("/users/{id}")
    Call<data_modal_put> putData(@Body data_modal_put put_data);
}
