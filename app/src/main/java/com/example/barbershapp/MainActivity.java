package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaCadastro(View v){
        Intent i = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(i);
    }

    public void irParaCadastroBarbearia(View v){
        Intent i = new Intent(MainActivity.this, CadastroBarbeariaActivity.class);
        startActivity(i);
    }
}