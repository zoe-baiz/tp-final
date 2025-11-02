package models;

import java.util.Scanner;

public class JuegoEscapeRoom {
    private Equipo equipo;
    private GestorSalas sala;

    public JuegoEscapeRoom(Equipo equipo, GestorSalas sala) {
        this.equipo = equipo;
        this.sala = sala;
    }

    public void jugar(){
        int pruebasResueltas=0;
        for(Sala s:sala.getSalas()){
            System.out.println("\u001B[0m--"+s.getNombre()+"--\u001B[0m");
            for (int i=0;i<s.getPruebas().size();i++) {
                for (Jugador j : equipo.getJugadores()) {
                    if(j.responderPrueba(j,s.getPruebas().get(i++))==true){
                        pruebasResueltas++;
                    }

                    if(pruebasResueltas == 15){
                        System.out.println("Fin:)");
                    }
                }
            }
        }
    }
}
