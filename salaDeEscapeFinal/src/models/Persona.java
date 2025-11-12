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
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
