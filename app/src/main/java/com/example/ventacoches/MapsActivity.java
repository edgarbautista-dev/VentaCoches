package com.example.ventacoches;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ventacoches.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        MarkerOptions marker1 = new MarkerOptions()
                .position(new LatLng(20.652715, -103.396024))
                .title("Ventas Run Run Car Zapopan");

        MarkerOptions marker2 = new MarkerOptions()
                .position(new LatLng(20.669077, -103.385516))
                .title("Ventas Run Run Car Guadalajara");

        MarkerOptions marker3 = new MarkerOptions()
                .position(new LatLng(20.673548, -103.396411))
                .title("Ventas Run Run Car Zapopan 2");

        MarkerOptions marker4 = new MarkerOptions()
                .position(new LatLng(20.640371, -103.409791))
                .title("Ventas Run Run Car Zapopan 3");

        mMap.addMarker(marker1);
        mMap.addMarker(marker2);
        mMap.addMarker(marker3);
        mMap.addMarker(marker4);
        LatLng location = new LatLng(20.6760607,-103.3674075);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,12.13f));
        // Add a marker in Sydney and move the camera
       /* LatLng location = new LatLng(20.6110, -105.2346);
        LatLng sucursal2 = new LatLng(20.652715, -103.396024);
        mMap.addMarker(new MarkerOptions().position(location).title("Marker in Vallarta"));
        mMap.addMarker(new MarkerOptions().position(sucursal2).title("Marker in Zapopan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));*/

    }
}