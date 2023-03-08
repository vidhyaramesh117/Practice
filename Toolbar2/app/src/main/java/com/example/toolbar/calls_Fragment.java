package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class calls_Fragment extends Fragment
{
    private Button button;
    private ProgressBar bar;
    boolean isProgressVisible = false;
    View rootview;

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
     {
        rootview = inflater.inflate(R.layout.fragment_calls_, container, false);

        button = rootview.findViewById(R.id.btn);
        bar = rootview.findViewById(R.id.pb);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(isProgressVisible)
                {
                    button.setText("Show Progress Bar");
                    bar.setVisibility(View.GONE);
                    isProgressVisible = false;
                }
                else
                {
                    isProgressVisible = true;
                    button.setText("Hide Progress Bar");
                    bar.setVisibility(View.VISIBLE);
                }

            }
        });
        return  rootview;
    }
}