package models;

import java.util.ArrayList;

public class GestorSalas {
    private ArrayList<Sala> salas;

    public GestorSalas() {
        this.salas=new ArrayList<>();
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    @Override
    public String toString() {
        return "GestorSalas{" +
                "salas=" + salas +
                '}';
    }
}
