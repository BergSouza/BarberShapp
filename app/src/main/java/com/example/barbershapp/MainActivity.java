package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.barbershapp.DAO.DAOBarbeiro;
import com.example.barbershapp.DAO.DAOContas;
import com.example.barbershapp.controller.BarbeiroController;
import com.example.barbershapp.controller.ContasController;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtUsuarioEmail;
    EditText edtTxtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTxtUsuarioEmail = findViewById(R.id.edtTxtUsuarioEmail);
        edtTxtSenha = findViewById(R.id.edtTxtSenha);

        BarbeiroController barbeiroController = new BarbeiroController();
    }

    public void irParaCadastro(View v){
        Intent i = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(i);
    }

    public void irParaCadastroBarbearia(View v){
        Intent i = new Intent(MainActivity.this, CadastroBarbeariaActivity.class);
        startActivity(i);
    }

    public void realizarLogin(View v){
        ContasController contasController = new ContasController();
        String usuarioEmail = String.valueOf(edtTxtUsuarioEmail.getText());
        String senha = String.valueOf(edtTxtSenha.getText());
        if(contasController.verificaLogin(usuarioEmail, senha)){
            Intent i = new Intent(MainActivity.this, SelecionarBarbeariaAcitivity.class);
            startActivity(i);
        }else{
            Toast toast = Toast.makeText(MainActivity.this, "Usuario/Email ou Senha Inválido(s)", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}