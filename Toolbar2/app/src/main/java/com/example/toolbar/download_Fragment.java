package com.example.toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
    Button button,btn;
    LinearLayout linearLayout;
    View rootview;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView refresh_tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_download_, container, false);

        button = rootview.findViewById(R.id.snack_btn);
        linearLayout = rootview.findViewById(R.id.lldwonload);
        swipeRefreshLayout = rootview.findViewById(R.id.swipe_refresh);
        refresh_tv = rootview.findViewById(R.id.swipe_tv);
        btn = rootview.findViewById(R.id.cus_snack);

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

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final Snackbar snackbar = Snackbar.make(view," ",Snackbar.LENGTH_LONG);
                View customSnackView = getLayoutInflater().inflate(R.layout.snack_bar_layout,null);
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0,0,0,0);
                Button cus_btn = customSnackView.findViewById(R.id.cus_snack);
                cus_btn.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {

                        Intent intent = new Intent(getContext(),Installed_page.class);
                        startActivity(intent);

//                        Toast.makeText(getContext(), "open", Toast.LENGTH_SHORT).show();
//                        snackbar.dismiss();
                    }
                });

                snackbarLayout.addView(customSnackView,0);
                snackbar.show();

            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() 

            {
                refresh_tv.setText("Internet connected");

                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return rootview;
    }
}