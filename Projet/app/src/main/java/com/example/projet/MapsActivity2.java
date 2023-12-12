package com.example.projet;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.projet.databinding.ActivityMaps2Binding;

import java.util.ArrayList;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;
    private Button btnRetour;
    private ArrayList<Informations> infoArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);

        btnRetour = (Button) findViewById(R.id.btnRetour) ;
        infoArrayList = getIntent().getParcelableArrayListExtra("infos");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5.0f));


            for (Informations infos : infoArrayList) {
                Log.d("onMapReady", "La Longitude  : " + infos.getLon());

                Log.d("onMapReady", "La Latitude  : " + infos.getLat());

                LatLng location = new LatLng(infos.getLon(), infos.getLat());

                mMap.addMarker(new MarkerOptions().position(location).title(infos.getPrecip()));


            }
                // Move the camera to the first location in the list
                LatLng firstLocation = new LatLng(infoArrayList.get(0).getLon(), infoArrayList.get(0).getLat());
                mMap.moveCamera(CameraUpdateFactory.newLatLng(firstLocation));

                btnRetour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });





    }
}