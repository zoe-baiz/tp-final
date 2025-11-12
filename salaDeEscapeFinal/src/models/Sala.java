package models;

import interfaces.Listador;

import java.util.ArrayList;
import java.util.Objects;

public class Sala implements Listador<Prueba> {
    private String nombre;
    private String historia;
    private ArrayList<Prueba> pruebas;
    private Integer id;
    private static int idGeneral=0;

    public Sala(String nombre, String historia) {
        this.nombre = nombre;
        this.historia = historia;
        idGeneral = idGeneral++;
        this.id = idGeneral;
    }

    public Sala() {
        this.nombre = "";
        this.historia = "";
        idGeneral = idGeneral++;
        this.id = idGeneral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Integer getId() {
        return id;
    }

    public static int getIdGeneral() {
        return idGeneral;
    }

    @Override
    public boolean agregar(Prueba p){
        return pruebas.add(p);
    }

    @Override
    public boolean eliminar(Prueba p){
        return pruebas.remove(p);
    }

    @Override
    public boolean buscar(Prueba p){
        for(Prueba b : pruebas){
            if(b.equals(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Prueba buscar(Integer id) {
        Prueba p = new Prueba(id);
        for(Prueba b : pruebas){
            if(b.equals(p)){
                return b;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sala sala)) return false;
        return id.equals(sala.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
