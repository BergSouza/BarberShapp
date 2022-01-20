package com.example.barbershapp.classes;

import java.util.ArrayList;

public class Barbearia {
    int id;
    String nome;
    ArrayList<Integer> barbeiros;
    int idDono;

    public Barbearia(int id, String nome, int idDono){
        this.id = id;
        this.nome = nome;
        this.idDono = idDono;

        barbeiros = new ArrayList<>();
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void addBarbeiro(int id){
        this.barbeiros.add(id);
    }
    public void removeBarbeiro(int id){
        for(int i = 0; i < this.barbeiros.size();i++) {
            if (this.barbeiros.get(i) == id) {
                this.barbeiros.remove(i);
            }
        }
    }
    public ArrayList<Integer> getBarbeiros(){
        return this.barbeiros;
    }
    public void setIdDono(int idDono){
        this.idDono = idDono;
    }
    public int getIdDono(){
        return this.idDono;
    }
}
