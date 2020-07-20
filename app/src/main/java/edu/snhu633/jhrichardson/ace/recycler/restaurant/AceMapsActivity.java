package edu.snhu633.jhrichardson.ace.recycler.restaurant;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AceMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double restaurant_lat;
    private double restaurant_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        this.restaurant_lat = extras.getDouble(getResources().getString(R.string.const_lat_key));
        this.restaurant_long = extras.getDouble(getResources().getString(R.string.const_long_key));
        setContentView(R.layout.activity_ace_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        LatLng ace = new LatLng(this.restaurant_lat, this.restaurant_long);
        mMap.addMarker(new MarkerOptions().position(ace).title(getResources().
                getString(R.string.ace_location_pin)));
        //Set the camera to the maker and zoom to street level
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ace));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(18.0f));
    }
}