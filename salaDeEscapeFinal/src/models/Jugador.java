package models;

public class Jugador extends Persona{
    private String nombre;
    private Integer cantVidas = 4;
    private Integer puntaje = 0;

    public Jugador(Integer id, String nombre, Integer puntaje) {
        super(id);
        this.nombre = nombre;
    }

    public Jugador(String nombre, Integer puntaje) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantVidas() {
        return cantVidas;
    }

    private void setCantVidas(Integer cantVidas) {
        this.cantVidas = cantVidas;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    private void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }


}
