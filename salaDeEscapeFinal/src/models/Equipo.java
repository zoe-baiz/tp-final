package models;

import java.util.HashSet;

public class Equipo {
    public String nombreEquipo;
    public String contraseña;
    HashSet<Jugador> jugadores;

    public Equipo(String nombreEquipo,String contraseña) {
        this.nombreEquipo=nombreEquipo;
        this.contraseña=contraseña;
        this.jugadores = new HashSet<>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public HashSet<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "jugadores=" + jugadores +
                '}';
    }
}
