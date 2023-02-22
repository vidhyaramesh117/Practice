package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class fav_Fragment extends Fragment
{
    CheckBox ch1, ch2, ch3, ch4;
    Button button;
    TextView toasttext;
    RadioGroup radioGroup;
    TextView radiotext;
    Switch swit;
    TextView swittext;

    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_fav_, container, false);
        addListenerOnButtonClick();
        radioGroup = rootview.findViewById(R.id.radio_grp);
        radiotext = rootview.findViewById(R.id.radio_tv);
        swit = rootview.findViewById(R.id.swit);
        swittext = rootview.findViewById(R.id.swit_tv);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId)
            {
                RadioButton radioButton = radioGroup.findViewById(checkedId);
                radiotext.setText(radioButton.getText());
            }
        });

        if(swit.isChecked())
        {
            swittext.setText("Online");
        }
        else
        {
            swittext.setText("Offline");
        }

        swit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked)
            {
                if(ischecked)
                {
                    swittext.setText("Online");
                }
                else
                {
                    swittext.setText("Offline");
                }

            }
        });

        return rootview;

    }

    private void addListenerOnButtonClick()
    {

        ch1 = rootview.findViewById(R.id.ch_as);
        ch2 = rootview.findViewById(R.id.ch_na);
        ch3 = rootview.findViewById(R.id.ch_ai);
        ch4 = rootview.findViewById(R.id.ch_ab);
        toasttext = rootview.findViewById(R.id.toast_tv);
        button = rootview.findViewById(R.id.ch_btn);
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup) rootview.findViewById(R.id.cus_toast));
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
//                    Toast toast = new Toast(getContext());
//                    toast.setDuration(Toast.LENGTH_LONG);
//                    toast.setView(layout);
//                    toast.show();

                Toast.makeText(getContext(),msg.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

}