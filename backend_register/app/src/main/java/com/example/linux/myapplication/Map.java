package com.example.linux.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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


    //@16.1991207, 103.2818035
    private Double Latitude2  = 16.1991207;
    private Double Longitude2 = 103.2818035;


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



            MarkerOptions marker = new MarkerOptions().position(new LatLng(Latitude2, Longitude2)).title("Marker in 2");
            googleMap.addMarker(marker);
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));





            googleMap.getUiSettings().setZoomGesturesEnabled(true);

        /*
        final LatLng TutorialsPoint = new LatLng(21 , 57);
        Marker TP = googleMap.addMarker(new MarkerOptions()
                .position(TutorialsPoint).title("TutorialsPoint"));
         */



            //*** Focus & Zoom
            googleMap.setMapType(com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom( coordinate  , 8 ));


            //Channing Map Type
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            // mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            //  mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

            googleMap.getUiSettings().setZoomGesturesEnabled(true);

            // mMap.setMapType(GoogleMap.MAP_TYPE_NONE);

            googleMap.getUiSettings().setRotateGesturesEnabled(true);
            //Compass Functionality
            googleMap.getUiSettings().setCompassEnabled(true);
            //My Location Button
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            googleMap.getUiSettings().setRotateGesturesEnabled(true);



            //*** Zoom Control
            googleMap.getUiSettings().setRotateGesturesEnabled(true);

            //*** RadioButton
            //rdoNormal = (RadioButton)findViewById(R.id.rdoNormal);


            //---------Check Enabled Location Services  เป็นการ check การเปิด location server GPS-------
            final AlertDialog.Builder adb = new AlertDialog.Builder(this);
            LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            boolean isGPS_Enabled = false;
            boolean isNetwork_Enabled = false;

            try {
                isGPS_Enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            } catch (Exception ex) { }

            try {
                isNetwork_Enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            } catch (Exception ex) { }

            if (!isGPS_Enabled && !isNetwork_Enabled) {

                adb.setTitle("Warning Location Services!!");
                adb.setMessage("Please Enable Location Services.");
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        // TODO Auto-generated method stub
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                });
                adb.show();

            }



        }





    }


}


