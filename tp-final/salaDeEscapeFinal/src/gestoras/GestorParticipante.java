package gestoras;

import exceptions.ParticipanteNoExisteException;
import exceptions.SinPistasException;
import models.Participante;

import java.util.ArrayList;

public class GestorParticipante {
    private Integer idEquipo;
    private Integer idParticipante;
    private Integer cantPistas = 2;
    private Integer puntos = 0;

    public GestorParticipante(Integer idParticipante, Integer idEquipo) {
        this.idParticipante = idParticipante;
        this.idEquipo = idEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Integer getCantPistas() {
        return cantPistas;
    }

    public void setCantPistas(Integer cantPistas) {
        this.cantPistas = cantPistas;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public void gestionarTrama() {
        //no entendi diri
    }

    public void bajarPistas() throws SinPistasException {
        if(this.cantPistas < 0) this.cantPistas--;
        else throw new SinPistasException();
    }

    public void reiniciarPistas() {
        this.cantPistas = 2;
    }

    public void sumarPuntos(Integer puntos) {
        this.puntos += puntos;
    }

    public void reiniciarPuntos() {
        this.puntos = 0;
    }

    public Participante elegirParticipante(ArrayList<Participante> lista) throws ParticipanteNoExisteException{
        Participante buscado = new Participante(this.idParticipante);

        for(Participante p : lista) if (buscado.equals(p)) return p;

        throw new ParticipanteNoExisteException();
    }
}
