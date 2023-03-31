package com.example.apiapp;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Submite_API
{
    @Multipart
    @POST ("file_upload/fileUpload.php")
    Call<Response_Pojo> submit_data (@Part MultipartBody.Part image,@Part ("email")String email,@Part ("website")String website);
}
