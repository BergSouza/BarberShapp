package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoBarbeariaActivity extends AppCompatActivity {

    //String barbearia = getIntent().getExtras().getString("nome");
    TextView txtViewNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_barbearia);

        //txtViewNome = findViewById(R.id.txtViewNome);
        //txtViewNome.setText(barbearia);
    }

    public void entrarNaFila(View view){
        Intent i = new Intent(InfoBarbeariaActivity.this, FilaBarbeariaActivity.class);
        i.putExtra("idBarbearia", getIntent().getExtras().getInt("idBarbearia"));
        startActivity(i);
    }
}