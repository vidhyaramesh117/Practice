package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class download_Fragment extends Fragment
{
    Button button;
    LinearLayout linearLayout;
    View rootview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_download_, container, false);

        button = rootview.findViewById(R.id.snack_btn);
        linearLayout = rootview.findViewById(R.id.lldwonload);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar snackbar = Snackbar.make(linearLayout,"Download completed",Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Toast.makeText(getActivity(), "Download failed", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });

        return rootview;
    }
}