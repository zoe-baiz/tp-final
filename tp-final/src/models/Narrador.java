package models;

public class Narrador {
    private String personaje;

    public Narrador(String personaje) {
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public void reproducirDialogo(String lineaId){
        System.out.print(personaje + ": " +lineaId);
    }
}
