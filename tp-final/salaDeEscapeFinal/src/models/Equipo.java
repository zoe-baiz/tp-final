package models;

import interfaces.IToJson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Equipo implements IToJson {
    private Integer id;
    private String nombreEquipo;
    private ArrayList<Participante> participantes;
    private Integer puntajeTotal;

    public Equipo(Integer id, String nombreEquipo) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.participantes = new ArrayList<>();
    }

    /*private Integer obtenerPuntajeTotal(){
        Integer sum = 0;

        for(Participante j : participantes){
            sum += j.getPuntaje();
        }

        return sum;
    }*/

    public boolean agregar(Participante p){
        if(p!=null){
            return participantes.add(p);
        }

        return false;
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


    public boolean eliminarParticipante(Participante j){
        return participantes.remove(j);
    }

    /*public void actualizarPuntaje(Integer puntos){
        puntajeTotal = obtenerPuntajeTotal();
        puntajeTotal += puntos;
    }*/

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

    @Override
    public JSONObject toJson() {
        JSONObject objEquipo=new JSONObject();
        JSONArray arrayParticipantes=new JSONArray();

        try{
            objEquipo.put("id",getId());
            objEquipo.put("nombreEquipo",getNombreEquipo());
            objEquipo.put("puntajeTotal",getPuntajeTotal());
            for(Participante p:participantes){
                arrayParticipantes.put(p.toJson());
            }
            objEquipo.put("participantes",arrayParticipantes);

        }catch (JSONException e){
            e.printStackTrace();
        }

        return objEquipo;
    }
}
