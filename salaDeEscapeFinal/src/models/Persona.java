// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import java.util.Objects;

public abstract class Persona {
    private Integer id;
    private String nombre;

    public Persona(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Persona(Integer id) {
        this.id = id;
        this.nombre = "";
    }

    public Persona() {
        this.id = -1;
        this.nombre = "";
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean equals(Object o) {
        if (o instanceof Persona persona) {
            return Objects.equals(this.id, persona.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
