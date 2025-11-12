package models;

import java.util.ArrayList;
import java.util.Objects;

public class Equipo {
    private Integer id;
    private String nombreEquipo;
    private ArrayList<Participante> participantes;
    private Integer puntajeTotal;

    public Equipo(Integer id, String nombreEquipo, ArrayList<Participante> participantes) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.participantes = participantes;
        this.puntajeTotal = obtenerPuntajeTotal();
    }

    public Equipo(Integer id, String nombreEquipo) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.participantes = new ArrayList<Participante>();
        this.puntajeTotal = obtenerPuntajeTotal();
    }

    private Integer obtenerPuntajeTotal(){
        Integer sum = 0;

        for(Participante j : participantes){
            sum += j.getPuntaje();
        }

        return sum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public boolean agregarParticipante(Participante j){
        return participantes.add(j);
    }

    public boolean eliminarParticipante(Participante j){
        return participantes.remove(j);
    }

    public void actualizarPuntaje(Integer puntos){
        puntajeTotal = obtenerPuntajeTotal();
        puntajeTotal += puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equipo equipo)) return false;
        return Objects.equals(id, equipo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", participantes=" + participantes +
                ", puntajeTotal=" + puntajeTotal +
                '}';
    }
}
