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

import java.util.ArrayList;

public class SelecionarBarbeariaAcitivity extends AppCompatActivity {

    ListView lista;
    int barbeariaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_barbearia_acitivity);

        lista = findViewById(R.id.LvBarbearias);

        DAOBarbearia daobarbearia = new DAOBarbearia();
        //daobarbearia.start();

        ArrayList<Barbearia> barbearias = daobarbearia.getBarbearias();
        ArrayList<String> barbeariasNome = pegaNome(barbearias);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, barbeariasNome);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //barbearia = barbearias.get(position);
                //Toast toast = Toast.makeText(SelecionarBarbeariaAcitivity.this, barbearias.get(position), Toast.LENGTH_SHORT);
                //toast.show();
                //barbeariaSelecionada = ;
                acessarBarbearia(barbearias.get(position).getId());
            }
        });
    }

    private ArrayList<String> pegaNome(ArrayList<Barbearia> barbearias) {
        ArrayList<String> dados = new ArrayList<>();
        for(int i = 0; i < barbearias.size();i++){
            dados.add(barbearias.get(i).getNome());
        }
        return dados;
    }

    public void acessarBarbearia(int id){
        Intent i = new Intent(SelecionarBarbeariaAcitivity.this, InfoBarbeariaActivity.class);
        i.putExtra("idBarbearia", id);
        startActivity(i);
    }
}