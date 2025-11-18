// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

public class gestorParticipante {
    public Participante participante;
    public int cantPistas;

    public gestorParticipante(Participante participante, int cantPistas) {
        this.participante = participante;
        this.cantPistas = cantPistas;
    }

    public Participante getParticipante() {
        return this.participante;
    }

    public int getCantPistas() {
        return this.cantPistas;
    }

    public void setCantPistas(int cantPistas) {
        this.cantPistas = cantPistas;
    }
}
