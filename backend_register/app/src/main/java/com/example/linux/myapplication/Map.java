package com.example.linux.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by linux on 18/11/2559.
 */

public class Map extends FragmentActivity {

    private GoogleMap googleMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        /*

        googleMap = ((SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.googleMap)).getMap();
                */



    }


}


