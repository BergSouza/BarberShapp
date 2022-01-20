package com.example.barbershapp.classes;

import java.util.ArrayList;

public class Barbeiro extends Usuario {
    int situacao;
    ArrayList<Integer> fila;

    public Barbeiro(int id, String nome, String usuario, String email, String senha){
        super(id, nome,usuario,email,senha);
        fila = new ArrayList<>();
    }

    public void setSituacao(int situacao){
        this.situacao = situacao;
    }
    public int getSituacao(){
        return this.situacao;
    }
    public void addUsuarioFila(int idUsuario){
        this.fila.add(idUsuario);
    }
    public int getPrimeiroUsuarioFila(){
        return this.fila.get(0);
    }
    public ArrayList<Integer> getFila(){
        return this.fila;
    }
    public boolean verificaUsuarioFila(int idUsuario){
        for(int i = 0; i < fila.size(); i++){
            if(fila.get(i) == idUsuario){
                return true;
            }
        }
        return false;
    }
    public void removeUsuarioFila(int idUsuario){
        for(int i = 0; i < fila.size(); i++){
            if(fila.get(i) == idUsuario){
                fila.remove(idUsuario);
            }
        }
    }
}
