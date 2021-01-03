package com.progdispmov.trabalhopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById( R.id.inputEmail );
        txtPassword = findViewById( R.id.inputPassword );
    }

    public void Login( String name ){
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }

    public void onClickCadastro(View view) {
        Intent intent = new Intent(view.getContext(),SigninActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view) {
        ConexaoDB conexao = new ConexaoDB();
        conexao.Login(getApplicationContext(), this, txtEmail.getText().toString(), txtPassword.getText().toString() );
    }
}