package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FilaBarbeariaActivity extends AppCompatActivity {

    ListView listaBarb;
    TextView txtViewBarbeiroSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fila_barbearia);

        listaBarb = findViewById(R.id.lvBarbeiros);
        ArrayList<String> barbeiros = preencheDados();
        ArrayAdapter<String> barbeirosAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, barbeiros);
        listaBarb.setAdapter(barbeirosAdapt);

        txtViewBarbeiroSelecionado = findViewById(R.id.txtViewNome);

        listaBarb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtViewBarbeiroSelecionado.setText("BARBEIRO SELECIONADO: "+barbeiros.get(position));
            }
        });
    }

    public ArrayList<String> preencheDados(){
        ArrayList<String> dados = new ArrayList<>();
        dados.add("Barbeiro 1 [Ocupado]");
        dados.add("Barbeiro 2 [Livre]");
        dados.add("Barbeiro 3 [Indisponível]");
        dados.add("Barbeiro 4 [Esperando]");
        return dados;
    }
}