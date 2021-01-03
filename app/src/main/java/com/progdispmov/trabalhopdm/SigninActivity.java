package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onClickRegistrar(View view) {
        EditText name = findViewById(R.id.inputName);
        EditText email = findViewById(R.id.inputEmail);
        EditText senha = findViewById(R.id.inputPassword);

        new ConexaoDB().Register(view.getContext(),this,name.getText().toString(),email.getText().toString(),senha.getText().toString());
    }

    public void toLogin() {
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}