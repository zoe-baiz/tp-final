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
        this.pruebas=new ArrayList<>();
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
        if(p!=null){
            return pruebas.add(p);
        }
        return false;
    }

    @Override
    public boolean eliminar(Prueba p){
        return pruebas.remove(p);
    }


    @Override
    public <T> T buscar(Integer id) {
        return null;
    }

    public ArrayList<Prueba> getPruebas() {
        return pruebas;
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
