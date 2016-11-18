package com.example.linux.myapplication;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by linux on 18/11/2559.
 */

public class Map extends FragmentActivity {



    // Google Map
    private GoogleMap googleMap;

    /*
    // Latitude & Longitude
    private Double Latitude  = 13.844205;
    private Double Longitude  = 100.598856;
*/


    //@16.4672351,102.826784
    private Double Latitude  = 16.4672351;
    private Double Longitude  = 102.826784;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



        if(Latitude > 0 && Longitude > 0)
        {

            //*** Display Google Map
            googleMap = ((SupportMapFragment)getSupportFragmentManager()
                    .findFragmentById(R.id.googleMap)).getMap();



            LatLng coordinate = new LatLng(Latitude, Longitude);

            //*** Focus & Zoom
            googleMap.setMapType(com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17));


            Marker TP = googleMap.addMarker(new MarkerOptions()
                    .position(coordinate).title("แสดงตำแหน่งการปักหมุด"));

            googleMap.addMarker(new MarkerOptions().position(coordinate).title("Marker in 1"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinate));


        }





    }


}


