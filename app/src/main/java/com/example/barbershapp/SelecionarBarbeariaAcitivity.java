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

import com.example.barbershapp.DAO.DAOBarbearia;
import com.example.barbershapp.classes.Barbearia;
import com.example.barbershapp.controller.BarbeariaController;

import java.util.ArrayList;

public class SelecionarBarbeariaAcitivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_barbearia_acitivity);

        lista = findViewById(R.id.LvBarbearias);

        BarbeariaController barbeariaController = new BarbeariaController();

        ArrayList<Barbearia> barbearias = barbeariaController.getBarbearias();
        ArrayList<String> barbeariasNome = barbeariaController.pegaNomes(barbearias);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, barbeariasNome);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                acessarBarbearia(barbearias.get(position).getId());
            }
        });
    }

    public void acessarBarbearia(int id){
        Intent i = new Intent(SelecionarBarbeariaAcitivity.this, InfoBarbeariaActivity.class);
        i.putExtra("idBarbearia", id);
        startActivity(i);
    }
}