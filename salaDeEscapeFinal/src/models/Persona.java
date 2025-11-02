package models;

import java.util.Objects;

public abstract class Persona {
    private Integer id;

    public Persona(Integer id) {
        this.id = id;
    }

    /*
    public Persona() {
        this.id = Integer.valueOf(-1);
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
