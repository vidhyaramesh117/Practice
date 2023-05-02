package com.example.googlemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

//FragmentActivity

    private GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        map = googleMap;
        LatLng perumbavoor_latLng = new LatLng(10.1146, 76.4778);
        MarkerOptions markerOptions = new MarkerOptions().position(perumbavoor_latLng).title("Perumbavoor");
        map.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLng(perumbavoor_latLng));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(perumbavoor_latLng,16f));
    }


//     @Override
//     public void onMapReady(@NonNull GoogleMap googleMap)
//     {
//
//     }
 }