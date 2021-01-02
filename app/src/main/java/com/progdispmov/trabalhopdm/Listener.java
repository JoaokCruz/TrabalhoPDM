package com.progdispmov.trabalhopdm;

import android.location.Location;
import android.location.LocationListener;

import androidx.annotation.NonNull;

public class Listener implements LocationListener {

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
    }
}
