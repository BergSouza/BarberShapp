package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void irParaLogin(View v){
        finish();
        //CadastroActivity cadAct;
        //Intent i = new Intent(MainActivity.this, CadastroActivity.class);
        //startActivity(i);
    }
}