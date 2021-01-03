package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.GnssAntennaInfo;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewRecordActivity extends AppCompatActivity {

    private LocationManager locationManager;


    EditText local,data;
    Button btnScan;

    boolean isScanning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        data = (EditText) findViewById(R.id.inputDate);
        local = (EditText) findViewById(R.id.inputPlace);
        btnScan = findViewById(R.id.btnScan);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isScanning) {
                    locationManager.removeTestProvider( LocationManager.NETWORK_PROVIDER);
                    locationManager.removeTestProvider( LocationManager.GPS_PROVIDER );
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                } else {
                    Bundle extras = getIntent().getExtras();
                    String id = extras.getString("id");
                    isScanning = true;
                    btnScan.setText("Parar rastreamento");
                    locationManager = (LocationManager) NewRecordActivity.this.getSystemService(Context.LOCATION_SERVICE);
                    new ConexaoDB().RegisterEntry(getApplicationContext(), NewRecordActivity.this,data.getText().toString(),local.getText().toString(),Integer.valueOf(id));
                }
            }
        });

    }

    protected void startScanning( Integer id )
    {
        Listener listener = new Listener( id, getApplicationContext());

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