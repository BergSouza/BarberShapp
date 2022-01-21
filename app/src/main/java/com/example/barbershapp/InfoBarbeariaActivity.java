package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.barbershapp.controller.BarbeariaController;

public class InfoBarbeariaActivity extends AppCompatActivity {

    TextView txtViewNome;
    TextView txtViewEndereco;
    TextView txtViewContato;
    TextView txtViewHorario;
    TextView txtViewFormasPagamento;
    int idBarbearia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_barbearia);

        idBarbearia = getIntent().getExtras().getInt("idBarbearia");

        BarbeariaController barbeariaController = new BarbeariaController();

        txtViewNome = findViewById(R.id.txtViewNome);
        txtViewEndereco = findViewById(R.id.txtViewEndereco);
        txtViewContato = findViewById(R.id.txtViewContato);
        txtViewHorario = findViewById(R.id.txtViewHorario);
        txtViewFormasPagamento = findViewById(R.id.txtViewFormasPagamento);

        txtViewNome.setText("BARBEARIA: "+barbeariaController.getNome(idBarbearia)+ "["+barbeariaController.getSituacao(idBarbearia)+"]");
        txtViewEndereco.setText("ENDEREÇO: "+barbeariaController.getEndereco(idBarbearia));
        txtViewContato.setText("CONTATO: "+barbeariaController.getContato(idBarbearia));
        txtViewHorario.setText("HORARIO: "+barbeariaController.getHorarioFuncionamento(idBarbearia));
        txtViewFormasPagamento.setText("FORMAS DE PAGAMENTO: "+barbeariaController.getFormasPagamento(idBarbearia));
    }

    public void entrarNaFila(View view){
        Intent i = new Intent(InfoBarbeariaActivity.this, FilaBarbeariaActivity.class);
        i.putExtra("idBarbearia", idBarbearia);
        startActivity(i);
    }
}