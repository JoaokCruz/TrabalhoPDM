package com.progdispmov.trabalhopdm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    Button btnEntry;
    String [] de = {"txtDate", "txtLocal", "txtID"};
    int [] para = {R.id.txtDate,R.id.txtLocal,R.id.txtID};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnEntry = findViewById(R.id.btnNewEntry);
        final Bundle extras = getIntent().getExtras();

        ConexaoDB conexaoDb = new ConexaoDB();

        conexaoDb.getEntries(getApplicationContext(), this, Integer.valueOf(extras.getString("id")));
        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id;

                Intent intent = new Intent(HomeActivity.this, NewRecordActivity.class);
                id = extras.getString("id");
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }

    protected void updateEntry(JSONObject obj) {
        List<HashMap<String,String>> lista = new ArrayList<>();
        Iterator iterator = obj.keys();
        String key;
        while (iterator.hasNext()) {
            try {
                key = String.valueOf(iterator.next());
                HashMap<String,String> map = new HashMap<>();
                if (obj.get(key) instanceof JSONObject) {
                    JSONObject xx = new JSONObject(obj.get(key).toString());
                    map.put("data",xx.getString("data"));
                    map.put("local",xx.getString("local"));
                    map.put("id",xx.getString("id"));
                }
                lista.add(map);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        ListView list = (ListView) findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(this,lista , R.layout.list_item, de,para);
        list.setAdapter(adapter);
    }
}