package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.util.Iterator;

public class HomeActivity extends AppCompatActivity {

    Button btnEntry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnEntry = findViewById( R.id.btnNewEntry );
        final Bundle extras = getIntent().getExtras();

        ConexaoDB conexaoDb = new ConexaoDB();

        conexaoDb.getEntries(getApplicationContext(), this, Integer.valueOf( extras.getString("id") ) );
        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;

                Intent intent = new Intent( HomeActivity.this, NewRecordActivity.class );
                id = extras.getString("id");
                intent.putExtra("id",id);
                startActivity( intent );
            }
        });
    }

    protected void updateEntry( JSONObject obj )
    {
        Iterator iterator = obj.keys();
        String key = String.valueOf( iterator.next() );
        while( iterator.hasNext() )
        {
            key = String.valueOf( iterator.next() );
        }
    }
}