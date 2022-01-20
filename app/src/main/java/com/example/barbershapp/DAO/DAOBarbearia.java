package com.example.barbershapp.DAO;

import com.example.barbershapp.classes.Barbearia;
import com.example.barbershapp.classes.Barbeiro;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DAOBarbearia{

    public static ArrayList<Barbearia> banco = preencherDados();

    public ArrayList<Barbearia> getBarbearias(){
        return banco;
    }

    public Barbearia getBarbearia(int id){
        for(int i = 0; i < banco.size();i++){
            if(banco.get(i).getId() == id){
                return banco.get(i);
            }
        }
        return null;
    }

    private static ArrayList<Barbearia> preencherDados(){
        ArrayList<Barbearia> barbearias = new ArrayList<>();
        DAOBarbeiro daobarbeiro = new DAOBarbeiro();
        //daobarbeiro.start();
        //daobarbeiro.wait();
        /*try {
            daobarbeiro.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        ArrayList<Barbeiro> barbeiros = daobarbeiro.getTodosBarbeiros();
        //Barbearia b1 = new Barbearia(1, "Barbearia1", barbeiros.get(0).getId());
        //Barbearia b2 = new Barbearia(2, "Barbearia2", barbeiros.get(1).getId());
        //Barbearia b3 = new Barbearia(3, "Barbearia3", barbeiros.get(2).getId());
        //Barbearia b4 = new Barbearia(4, "Barbearia4", barbeiros.get(3).getId());
        //Barbearia b5 = new Barbearia(5, "Barbearia5", barbeiros.get(4).getId());
        //Barbearia b6 = new Barbearia(6, "Barbearia6", barbeiros.get(5).getId());
        Barbearia b1 = new Barbearia(1, "Barbearia1", 1);
        Barbearia b2 = new Barbearia(2, "Barbearia2", 2);
        Barbearia b3 = new Barbearia(3, "Barbearia3", 3);
        Barbearia b4 = new Barbearia(4, "Barbearia4", 4);
        Barbearia b5 = new Barbearia(5, "Barbearia5", 5);
        Barbearia b6 = new Barbearia(6, "Barbearia6", 6);
        b1.addBarbeiro(7);
        b1.addBarbeiro(8);
        b2.addBarbeiro(9);
        b2.addBarbeiro(10);
        b3.addBarbeiro(11);
        b4.addBarbeiro(12);
        b4.addBarbeiro(13);
        b5.addBarbeiro(14);
        b5.addBarbeiro(15);
        b6.addBarbeiro(16);
        barbearias.add(b1);
        barbearias.add(b2);
        barbearias.add(b3);
        barbearias.add(b4);
        barbearias.add(b5);
        barbearias.add(b6);
        return barbearias;
    }
}
