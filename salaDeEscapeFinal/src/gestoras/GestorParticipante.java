// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package gestoras;

import exceptions.ParticipanteNoExisteException;
import exceptions.SinPistasException;
import java.util.ArrayList;
import java.util.Iterator;

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
        return this.idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdParticipante() {
        return this.idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Integer getCantPistas() {
        return this.cantPistas;
    }

    public void setCantPistas(Integer cantPistas) {
        this.cantPistas = cantPistas;
    }

    public Integer getPuntos() {
        return this.puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public void gestionarTrama() {
    }

    public void bajarPistas() throws SinPistasException {
        if (this.cantPistas < 0) {
            Integer var1 = this.cantPistas;
            this.cantPistas = this.cantPistas - 1;
        } else {
            throw new SinPistasException();
        }
    }

    public void reiniciarPistas() {
        this.cantPistas = 2;
    }

    public void sumarPuntos(Integer puntos) {
        this.puntos = this.puntos + puntos;
    }

    public void reiniciarPuntos() {
        this.puntos = 0;
    }

    public Participante elegirParticipante(ArrayList<Participante> lista) throws ParticipanteNoExisteException {
        Participante buscado = new Participante(this.idParticipante);
        Iterator var3 = lista.iterator();

        Participante p;
        do {
            if (!var3.hasNext()) {
                throw new ParticipanteNoExisteException();
            }

            p = (Participante)var3.next();
        } while(!buscado.equals(p));

        return p;
    }
}
