package com.example.vinay.mymapsapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     * 13.335154, 77.114812


     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(13.3269, 77.1261);
        Marker m1=mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in SIT TUMKUR"));
        m1.showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng hospital = new LatLng(13.335612, 77.116813);
        Marker m2=mMap.addMarker(new MarkerOptions().position(hospital).title("this is our hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hospital));
        m2.showInfoWindow();



        LatLng park = new LatLng(13.335154, 77.114812);
        Marker m3=mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)).position(park).title("my park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(park));
        m3.showInfoWindow();
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        drawCircle(park);




        }

    private void drawCircle( LatLng park) {
        CircleOptions options = new CircleOptions();
        options.center( park );
        //Radius in meters
        options.radius( 1000 );
        options.fillColor( getResources()
                .getColor( R.color.a ) );
        options.visible(true);
        options.strokeColor( getResources()
                .getColor( R.color.b ) );
        options.strokeWidth( 1 );
        mMap.addCircle(options);
    }





}


