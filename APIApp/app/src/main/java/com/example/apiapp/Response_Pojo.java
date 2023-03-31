package com.example.apiapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response_Pojo
{
    @SerializedName("file_name")
    @Expose
    private String file_name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("file_path")
    @Expose
    private String file_path;

    public String getFile_name()
    {
        return file_name;
    }

    public void setFile_name(String file_name)
    {
        this.file_name = file_name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public String getFile_path()
    {
        return file_path;
    }

    public void setFile_path(String file_path)
    {
        this.file_path = file_path;
    }
}
