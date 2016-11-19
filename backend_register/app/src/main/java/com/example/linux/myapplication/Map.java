package com.example.linux.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
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


    //@15.9395477,103.5304926
    private Double Latitude3  = 15.9395477;
    private Double Longitude3  = 103.5304926;


    //กาฬสินธุ์/@16.6427287,103.3881626,
    private Double Latitude4  = 16.6427287;
    private Double Longitude4  = 103.3881626;


    //@16.1876986,102.8692588
    private Double Latitude5  = 16.1876986;
    private Double Longitude5  = 102.8692588;

    ///@15.9884487,103.9252753
    private Double Latitude6  = 15.9884487;
    private Double Longitude6 = 103.9252753;


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

            Circle circle = googleMap.addCircle(new CircleOptions()
                    .center(new LatLng(Latitude2, Longitude2 ))
                    .radius(3000)
                    .strokeColor(Color.RED)
                    .fillColor(Color.BLUE));


            MarkerOptions marker = new MarkerOptions().position(new LatLng(Latitude2, Longitude2)).title("Marker in 2");
            googleMap.addMarker(marker);
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));




            MarkerOptions marker3 = new MarkerOptions().position(new LatLng(Latitude3, Longitude3)).title("Marker in 3");
            googleMap.addMarker(marker3);
            marker3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));




            MarkerOptions marker4 = new MarkerOptions().position(new LatLng(Latitude4, Longitude4)).title("Marker in 4");
            googleMap.addMarker(marker4);
            marker4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));


            MarkerOptions marker5 = new MarkerOptions().position(new LatLng(Latitude5, Longitude5)).title("Marker in 5");
            googleMap.addMarker(marker5);
            marker5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));


            MarkerOptions marker6 = new MarkerOptions().position(new LatLng(Latitude6, Longitude6)).title("Marker in 6");
            googleMap.addMarker(marker6);
            marker6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));


            //------------ options googlemap-------------------------------

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


