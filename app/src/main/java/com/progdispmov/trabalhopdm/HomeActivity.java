package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnEntry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnEntry = findViewById( R.id.btnNewEntry );

        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;
                Bundle extras = getIntent().getExtras();
                Intent intent = new Intent( HomeActivity.this, NewRecordActivity.class );
                id = extras.getString("id");
                intent.putExtra("id",id);
                startActivity( intent );
            }
        });
    }
}