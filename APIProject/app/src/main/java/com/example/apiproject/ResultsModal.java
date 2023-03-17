package com.example.apiproject;

import com.google.gson.annotations.SerializedName;

public class ResultsModal {
    @SerializedName("name")
    private String superName;

    public ResultsModal(String superName){
        this.superName=superName;
    }

    public String getSuperName() {
        return superName;
    }
}
