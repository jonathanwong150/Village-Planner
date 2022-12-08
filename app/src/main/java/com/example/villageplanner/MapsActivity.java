package com.example.villageplanner;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.villageplanner.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Intent intent;
    private String user_key;
    private String email_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        intent = getIntent();
        user_key = intent.getStringExtra("userKey");
        email_key= intent.getStringExtra("emailKey");
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void goToReminders(View view) {
        Intent toRemind = new Intent(this, ReminderActivity.class);
        toRemind.putExtra("userKey",user_key);
        toRemind.putExtra("emailKey", email_key);
        startActivity(toRemind);
    }
    public void goToProfile(View view) {
        Intent toProfile = new Intent(this, ProfileActivity.class);
        toProfile.putExtra("userKey",user_key);
        toProfile.putExtra("emailKey", email_key);
        startActivity(toProfile);
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

        // Add a marker in Village and move the camera
        mMap.setTrafficEnabled(true);
        LatLng Village= new LatLng(34.0256, -118.2850);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Village,17f));
        LatLng Cava = new LatLng(34.02511375365603, -118.28447370997834);
        LatLng Kenjo = new LatLng(34.025047957936714, -118.28530553038058);
        LatLng Dulce = new LatLng(34.0254900321678, -118.28555573323058);
        LatLng Honeybird = new LatLng(34.02486319956033, -118.28451435291088);
        LatLng Kobunga = new LatLng(34.02465995287975, -118.28559346674429);
        LatLng Joe = new LatLng(34.02611840079535, -118.28465750009852);
        LatLng Target= new LatLng(34.026053615760716, -118.28418259694581);
        LatLng Stout = new LatLng(34.02479598023349, -118.28468916350408);
        LatLng Insomnia = new LatLng(34.02505280850822, -118.28533847900466);
        mMap.addMarker(new MarkerOptions().position(Cava).title("Cava").snippet("C"));
        mMap.addMarker(new MarkerOptions().position(Kenjo).title("Ramen Kenjo"));
        mMap.addMarker(new MarkerOptions().position(Dulce).title("Dulce"));
        mMap.addMarker(new MarkerOptions().position(Honeybird).title("Honeybird"));
        mMap.addMarker(new MarkerOptions().position(Kobunga).title("Kobunga"));
        mMap.addMarker(new MarkerOptions().position(Joe).title("Trader Joe's"));
        mMap.addMarker(new MarkerOptions().position(Target).title("Target"));
        mMap.addMarker(new MarkerOptions().position(Insomnia).title("Insomnia Cookies"));
        mMap.addMarker(new MarkerOptions().position(Stout).title("Stout Burgers & Beers"));

        mMap.setOnMarkerClickListener(this);
    }
    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Intent intent = new Intent(this, QueueTimesActivity.class);
        intent.putExtra("res",marker.getTitle());
        intent.putExtra("userKey",user_key);
        intent.putExtra("emailKey", email_key);
        startActivity(intent);
        return false;
    }
}