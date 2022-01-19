package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelecionarBarbeariaAcitivity extends AppCompatActivity {

    ListView lista;
    //String barbearia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_barbearia_acitivity);

        lista = findViewById(R.id.LvBarbearias);

        ArrayList<String> barbearias = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, barbearias);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //barbearia = barbearias.get(position);
                //Toast toast = Toast.makeText(SelecionarBarbeariaAcitivity.this, barbearias.get(position), Toast.LENGTH_SHORT);
                //toast.show();
                acessarBarbearia();
            }
        });
    }

    private ArrayList<String> preencherDados(){
        ArrayList<String> barbearias = new ArrayList<String>();
        barbearias.add("Barbearia1");
        barbearias.add("Barbearia2");
        barbearias.add("Barbearia3");
        barbearias.add("Barbearia4");
        barbearias.add("Barbearia5");
        barbearias.add("Barbearia6");
        return barbearias;
    }

    public void acessarBarbearia(){
        Intent i = new Intent(SelecionarBarbeariaAcitivity.this, InfoBarbeariaActivity.class);
        startActivity(i);
    }
}