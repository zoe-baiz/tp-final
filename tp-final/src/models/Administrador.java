package models;

import interfaces.IContrasenia;

import java.util.ArrayList;

public class Administrador extends Persona implements IContrasenia {
    private String contrasenia;
    private final ArrayList<String> permisos;

    public Administrador(Integer id, String nombre, String contrasenia) {
        super(id, nombre);
        this.contrasenia = contrasenia;
        this.permisos = new ArrayList<String>();
    }

    public Administrador(Integer id) {
        super(id);
        this.contrasenia = "";
        this.permisos = new ArrayList<String>();
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean agregarPermisos(String p){
        return permisos.add(p);
    }

    public boolean eliminarPermisos(String p){
        return permisos.remove(p);
    }

    @Override
    public boolean autenticar(String usuario, String contrasenia) {
        return (usuario.equals(this.getNombre()) && contrasenia.equals(this.contrasenia));
    }
}
