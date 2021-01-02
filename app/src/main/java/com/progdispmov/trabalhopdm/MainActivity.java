package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        System.out.println("MySQL Connect Example.");
        Connection conn = null;
        String url = "jdbc:mysql://jcruz1.mysql.pythonanywhere-services.com/";
        String dbName = "trabalho";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "jcruz1";
        String password = "trabalhopdm";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);
            Toast.makeText(getApplicationContext(), "Conexao aberta!", Toast.LENGTH_SHORT).show();
            System.out.println("Connected to the database");
            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
