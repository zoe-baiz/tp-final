package models;

import enums.TipoDePrueba;
import interfaces.Listador;

import java.util.ArrayList;
import java.util.Objects;

public class Prueba implements Listador<Pista> {
    public static int idGeneral=-1;
    private Integer id;
    private String nombre;
    private String descripcion;
    private TipoDePrueba tipo;
    private ArrayList<Pista> pistas;
    private String respuesta;

    public Prueba(String nombre, String descripcion, TipoDePrueba tipo,String respuesta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.respuesta=respuesta;
        idGeneral++;
        this.id = idGeneral;
    }

    /*
    public Prueba(Integer id) {
        this.nombre = "";
        this.descripcion = "";
        this.tipo = TipoDePrueba.LOGICA;
        this.id = id;
    }

    public Prueba() {
        this.nombre = "";
        this.descripcion = "";
        this.tipo = TipoDePrueba.LOGICA;
        this.id = -1;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDePrueba getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePrueba tipo) {
        this.tipo = tipo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean agregar(Pista p){
        return pistas.add(p);
    }

    @Override
    public boolean eliminar(Pista p){
        return pistas.remove(p);
    }

    @Override
    public Pista buscar(Integer id) {
        Pista p = new Pista(id);
        for(Pista b : pistas){
            if(b.equals(p)){
                return b;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Prueba prueba)) return false;
        return id.equals(prueba.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Prueba{" +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo=" + tipo +
                '}';
    }


}
