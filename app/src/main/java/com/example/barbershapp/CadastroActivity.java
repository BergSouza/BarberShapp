package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.barbershapp.DAO.DAOContas;
import com.example.barbershapp.DAO.DAOUsuario;
import com.example.barbershapp.classes.Usuario;
import com.example.barbershapp.controller.UsuarioController;

public class CadastroActivity extends AppCompatActivity {

    EditText edtTxtUsuario;
    EditText edtTxtNome;
    EditText edtTxtEmail;
    EditText edtTxtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void irParaLogin(View v){
        finish();
    }

    public void realizarCadastro(View v){
        UsuarioController usuarioController = new UsuarioController();
        edtTxtNome = findViewById(R.id.edtTxtNome);
        edtTxtUsuario = findViewById(R.id.edtTxtUsuario);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtSenha = findViewById(R.id.edtTxtSenha);
        String nome = String.valueOf(edtTxtNome.getText());
        String usuario = String.valueOf(edtTxtUsuario.getText());
        String email = String.valueOf((edtTxtEmail.getText()));
        String senha = String.valueOf((edtTxtSenha.getText()));
        Usuario newUser = new Usuario(0,nome,usuario,email,senha);
        if(usuarioController.insertUsuario(newUser)){
            Toast toast = Toast.makeText(CadastroActivity.this, "Conta criada com sucesso!", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }else{
            Toast toast = Toast.makeText(CadastroActivity.this, "Usuario ou(e) Email já cadastrado(s)! Tente outro(s)", Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}