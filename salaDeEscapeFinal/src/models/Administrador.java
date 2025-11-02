package models;

public class Administrador extends Persona {
    private String contrasenia;

    public Administrador(Integer id, String contrasenia) {
        super(id);
        this.contrasenia = contrasenia;
    }

    /*
    public Administrador(String contrasenia) {
        this.contrasenia = contrasenia;
    }*/

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
