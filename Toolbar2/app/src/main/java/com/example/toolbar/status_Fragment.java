package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class status_Fragment extends Fragment {

    private int CurrentP=0;
    private ProgressBar pbar;
    private Button button;
    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_status_, container, false);
        pbar = rootview.findViewById(R.id.pbh);
        button = rootview.findViewById(R.id.btun);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CurrentP = CurrentP + 10;
                pbar.setProgress(CurrentP);
                pbar.setMax(100);
                if(CurrentP>100)
                {
                    CurrentP=0;
                    pbar.setMax(0);
                }
            }
        });
        return rootview;
    }
}