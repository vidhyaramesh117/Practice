package com.example.apiapp;

public class data_modal_update
{
    private String name;
    private String qualification;

    public data_modal_update(String name,String qualification)
    {
        this.name = name;
        this.qualification = qualification;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getQualification()
    {
        return qualification;
    }

    public void setQualification(String qualification)
    {
        this.qualification = qualification;
    }
}
