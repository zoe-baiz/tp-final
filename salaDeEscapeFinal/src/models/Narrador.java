// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

public class Narrador {
    private String personaje;

    public Narrador(String personaje) {
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return this.personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public void reproducirDialogo(String lineaId) {
        System.out.print(this.personaje + ": " + lineaId);
    }
}
