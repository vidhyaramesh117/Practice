package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class fav_Fragment extends Fragment
{
    CheckBox ch1, ch2, ch3, ch4;
    Button button;
    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_fav_, container, false);
        addListenerOnButtonClick();
        return rootview;

    }

    private void addListenerOnButtonClick()
    {

        ch1 = rootview.findViewById(R.id.ch_as);
        ch2 = rootview.findViewById(R.id.ch_na);
        ch3 = rootview.findViewById(R.id.ch_ai);
        ch4 = rootview.findViewById(R.id.ch_ab);
        button = rootview.findViewById(R.id.ch_btn);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                StringBuilder msg = new StringBuilder();
                msg.append("Favourites : ");
                if (ch1.isChecked())
                {
                    msg.append("Aswin \t");

                }
                if (ch2.isChecked())
                {
                    msg.append("Nasrin \t");

                }
                if (ch3.isChecked())
                {
                    msg.append("Aibi \t");

                }
                if (ch4.isChecked())
                {
                    msg.append("Abel \t");

                }
                Toast.makeText(getContext(),msg.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}