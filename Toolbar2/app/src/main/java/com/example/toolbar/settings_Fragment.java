package com.example.toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class settings_Fragment extends Fragment
{
    TextView time;
    Button timebtn;
    View rootview;
    TextView date;
    Button datebtn;
    TextView current_date;
    TextView current_time;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_settings_, container, false);

        time = rootview.findViewById(R.id.time_tv);
       timebtn = rootview.findViewById(R.id.time_btn);
       date = rootview.findViewById(R.id.date_tv);
       datebtn = rootview.findViewById(R.id.date_btn);
       current_date = rootview.findViewById(R.id.cur_date);
       current_time = rootview.findViewById(R.id.cur_time);


        timebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final Calendar c = Calendar.getInstance();

                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);

                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                String strtime = "Current Time: "+format.format(c.getTime());
                display(strtime);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minOfDay)
                    {
                        String AM_PM =null;
                        if(hourOfDay>12)
                        {
                            hourOfDay=(hourOfDay-12);
                            AM_PM ="PM";
                        }
                        else if(hourOfDay<12)
                        {
                            AM_PM ="AM";
                        }
                        else
                        {
                            AM_PM = "PM";
                        }
                        if(minOfDay<10){
                            time.setText( "Picked Time: "+hourOfDay + ":0" + minOfDay+" "+AM_PM);
                        }
                        else {
                            time.setText( "Picked Time: "+hourOfDay + ":" + minOfDay+" "+AM_PM);
                        }

                    }

                  
                },hour,min,false);
                timePickerDialog.show();
            }
            });

        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                current_date.setText("Today: "+year+"-"+(month+1)+"-"+day);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dateofmonth)
                    {
                        date.setText("Picked Date: "+dateofmonth+"-"+(monthofyear+1)+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        return rootview;


    }


    private void display(String strtime)
    {
        current_time.setText(strtime);
        Log.i("settings_Fragment","qwerty");
    }
}