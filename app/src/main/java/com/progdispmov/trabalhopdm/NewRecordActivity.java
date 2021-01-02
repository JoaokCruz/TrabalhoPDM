package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GnssAntennaInfo;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewRecordActivity extends AppCompatActivity {

    private LocationManager locationManager;

    Button btnScan;

    boolean isScanning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        btnScan = findViewById(R.id.btnScan);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isScanning) {
                    //exit activity and save to database
                } else {
                    isScanning = true;
                    btnScan.setText("Parar rastreamento");

                    locationManager = (LocationManager) NewRecordActivity.this.getSystemService(Context.LOCATION_SERVICE);

                    Listener listener = new Listener();

                    long tempoAtualizacao = 1;
                    float distancia = 0;
                    if (ActivityCompat.checkSelfPermission(NewRecordActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(NewRecordActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, tempoAtualizacao, distancia, listener);

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, tempoAtualizacao, distancia, listener);
                    //start scanning
                }
            }
        });

    }
}