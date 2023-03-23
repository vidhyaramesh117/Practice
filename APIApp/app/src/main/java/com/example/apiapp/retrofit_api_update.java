package com.example.apiapp;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface retrofit_api_update
{
    @PUT("api/users/2")
    Call<data_modal_update> updateData(@Body data_modal_update update_data);

}
