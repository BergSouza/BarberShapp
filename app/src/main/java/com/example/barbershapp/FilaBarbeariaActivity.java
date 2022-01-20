package com.example.barbershapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.barbershapp.DAO.DAOBarbeiro;
import com.example.barbershapp.classes.Barbeiro;

import java.util.ArrayList;

public class FilaBarbeariaActivity extends AppCompatActivity {

    ListView listaBarb;
    TextView txtViewBarbeiroSelecionado;
    TextView txtViewPessoasNaFila;
    TextView txtPosicaoFila;
    Button btnFila;
    int barbeariaSelecionada;
    int posicaoBarbeiroSelecionado;
    ArrayList<Barbeiro> barbeiros;

    DAOBarbeiro daobarbeiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fila_barbearia);

        listaBarb = findViewById(R.id.lvBarbeiros);
        barbeariaSelecionada = getIntent().getExtras().getInt("idBarbearia");
        ArrayList<Barbeiro> barbeiros = daobarbeiro.getBarbeirosDaBarbearia(barbeariaSelecionada);
        ArrayList<String> barbeirosNomes = pegaNomes(barbeiros);
        ArrayList<Integer> barbeirosSituacao = pegaSituacoes(barbeiros);
        ArrayList<String> showBarbeiros = showInfoBarbeiros(barbeiros);

        ArrayAdapter<String> barbeirosAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, showBarbeiros);
        listaBarb.setAdapter(barbeirosAdapt);

        daobarbeiro = new DAOBarbeiro();

        txtViewBarbeiroSelecionado = findViewById(R.id.txtViewBarbeiroSelecionado);
        txtViewPessoasNaFila = findViewById(R.id.txtViewPessoasFila);
        btnFila = findViewById(R.id.btnFila);

        listaBarb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtViewBarbeiroSelecionado.setText("BARBEIRO SELECIONADO: "+barbeirosNomes.get(position));
                txtViewPessoasNaFila.setText("PESSOAS NA FILA: "+daobarbeiro.getTotalFila(barbeiros.get(position).getId()));
                posicaoBarbeiroSelecionado = position;
            }
        });
    }

    private ArrayList<String> showInfoBarbeiros(ArrayList<Barbeiro> barbeiros) {
        ArrayList<String> dados = new ArrayList<>();
        for(int i = 0; i < barbeiros.size();i++){
            String situacao = null;
            if(barbeiros.get(i).getSituacao() == 1){
                situacao = "Livre";
            }
            if(barbeiros.get(i).getSituacao() == 2){
                situacao = "Ocupado";
            }
            if(barbeiros.get(i).getSituacao() == 3){
                situacao = "Esperando";
            }
            if(barbeiros.get(i).getSituacao() == 4){
                situacao = "Indisponível";
            }
            dados.add(barbeiros.get(i).getNome()+" ["+situacao+"]");
        }
        return dados;
    }



    public ArrayList<String> pegaNomes(ArrayList<Barbeiro> barbeiros){
        ArrayList<String> dados = new ArrayList<>();
        for(int i = 0; i < barbeiros.size();i++){
            dados.add(barbeiros.get(i).getNome());
        }
        return dados;
    }
    public ArrayList<Integer> pegaSituacoes(ArrayList<Barbeiro> barbeiros){
        ArrayList<Integer> dados = new ArrayList<>();
        for(int i = 0; i < barbeiros.size();i++){
            dados.add(barbeiros.get(i).getSituacao());
        }
        return dados;
    }

    public void BotaoFila(View v){
        //int posicaoFila = daobarbeiro.getPosicaoFila(barbeiros.get(posicaoBarbeiroSelecionado).getId(), 0);
        //if(posicaoFila == 0){
        //    entrarNaFila();
        //}else{
        //   sairDaFila();
        //}
    }

    public void entrarNaFila(){
        //btnFila.setText("SAIR DA FILA");
        //daobarbeiro.insertUsuarioFila(barbeiros.get(posicaoBarbeiroSelecionado).getId(), 0);
        //txtPosicaoFila.setText("VOCÊ ESTÁ NA FILA!");
    }

    public void sairDaFila(){
        //btnFila.setText("ENTRAR NA FILA");
        //daobarbeiro.removeUsuarioFila(barbeiros.get(posicaoBarbeiroSelecionado).getId(), 0);
        //txtPosicaoFila.setText("VOCÊ NÃO ESTÁ NA FILA!");
    }
}