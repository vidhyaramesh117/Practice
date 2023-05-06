package com.example.google_maps_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.Manifest;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.google_maps_api.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity
{

    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = com.example.google_maps_api.Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION= com.example.google_maps_api.Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE  1234;

    private Boolean locationPermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);



    }

    private void getLocationPermission()
    {
        String[] permissions = { Manifest.permission.ACCESS_FINE_LOCATION,
                com.example.google_maps_api.Manifest.permission.ACCESS_COARSE_LOCATION };
       if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
       {
           if (ContextCompat.checkSelfPermission(this.getApplicationContext(),COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
           {
               locationPermissionGranted = true;
           }
           else
           {
               ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
           }
       }
    }
    @Override
    public void onRequestPermissionResult(int request_code, @NonNull String[] permissions,@NonNull int[] grant_results)
    {
        locationPermissionGranted = false;

        switch (request_code)
        {
            case LOCATION_PERMISSION_REQUEST_CODE:
            {
                if (grant_results.length >0)
                {
                    for (int i = 0; i < grant_results.length; i++)
                    {
                        if (grant_results[i] != PackageManager.PERMISSION_GRANTED)
                        {
                            locationPermissionGranted = false;
                            return;
                        }
                        locationPermissionGranted = true;
                    }
                }
            }
        }
    }


}