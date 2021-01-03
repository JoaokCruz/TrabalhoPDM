package com.progdispmov.trabalhopdm;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;

import androidx.annotation.NonNull;

public class Listener implements LocationListener {

    Integer id;
    Context context;
    public Listener( Integer id, Context context ) {
        this.id = id;
        this.context = context;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        ConexaoDB conexao = new ConexaoDB();

        conexao.RegisterGeolocal( context, String.valueOf( latitude ), String.valueOf( longitude ), id );
    }
}
