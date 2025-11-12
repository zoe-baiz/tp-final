package models;

import interfaces.IContrasenia;

public class Participante extends Persona implements IContrasenia {
    private String contrasenia;
    private Integer cantVidas = 3;
    private Integer puntaje = 0;
    private Integer idEquipo;

    public Participante(Integer id, String nombre, String contrasenia, Integer idEquipo) {
        super(id, nombre);
        this.contrasenia = contrasenia;
        this.idEquipo = idEquipo;
    }

    public Participante(Integer id) {
        super(id);
        this.contrasenia = "";
        this.idEquipo = -1;
    }

    public Participante() {
        this.contrasenia = "";
        this.idEquipo = -1;
    }

    public Integer getCantVidas() {
        return cantVidas;
    }

    private void setCantVidas(Integer cantVidas) {
        this.cantVidas = cantVidas;

    }

    public Integer getPuntaje() {
        return puntaje;
    }

    private void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void perderVida(){
        this.cantVidas--;
    }

    public void ganarPuntos(int puntos){
        this.puntaje += puntos;
    }

    @Override
    public boolean autenticar(String usuario, String contrasenia) {
        if(usuario.equals(this.getNombre()) && contrasenia.equals(this.contrasenia)) return true;
        return false;
    }
}
