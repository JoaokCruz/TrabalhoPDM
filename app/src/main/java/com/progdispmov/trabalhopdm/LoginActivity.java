package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void onClickCadastro(View view) {
        Intent intent = new Intent(view.getContext(),SigninActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view) {
    }
}