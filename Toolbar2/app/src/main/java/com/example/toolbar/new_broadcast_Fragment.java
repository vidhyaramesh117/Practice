package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class new_broadcast_Fragment extends Fragment
{
    ImageView imageView;
    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_new_broadcast_, container, false);

        imageView = rootview.findViewById(R.id.back_arrow);

        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });

        return rootview;
    }
}