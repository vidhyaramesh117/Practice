package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class groups_Fragment extends Fragment {

    public groups_Fragment()
    {

    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
   {
        return inflater.inflate(R.layout.fragment_groups_, container, false);
    }
}