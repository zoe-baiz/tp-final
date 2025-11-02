package models;

import java.util.Objects;

public class Pista {
    private Integer id;
    private String texto;

    public Pista(Integer id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Pista(Integer id) {
        this.id = id;
        this.texto = "";
    }

    public Pista() {
        this.id = -1;
        this.texto = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pista pista)) return false;
        return Objects.equals(id, pista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Pista{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                '}';
    }
}
