// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import interfaces.IToJson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Equipo implements IToJson {
    private Integer id;
    private String nombreEquipo;
    private ArrayList<Participante> participantes;
    private Integer puntajeTotal;

    public Equipo(Integer id, String nombreEquipo) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.participantes = new ArrayList();
    }

    public boolean agregar(Participante p) {
        return p != null ? this.participantes.add(p) : false;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return this.nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public ArrayList<Participante> getParticipantes() {
        return this.participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public Integer getPuntajeTotal() {
        return this.puntajeTotal;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public boolean eliminarParticipante(Participante j) {
        return this.participantes.remove(j);
    }

    public boolean equals(Object o) {
        if (o instanceof Equipo equipo) {
            return Objects.equals(this.id, equipo.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    public String toString() {
        Integer var10000 = this.id;
        return "Equipo{id=" + var10000 + ", nombreEquipo='" + this.nombreEquipo + "', participantes=" + String.valueOf(this.participantes) + ", puntajeTotal=" + this.puntajeTotal + "}";
    }

    public JSONObject toJson() {
        JSONObject objEquipo = new JSONObject();
        JSONArray arrayParticipantes = new JSONArray();

        try {
            objEquipo.put("id", this.getId());
            objEquipo.put("nombreEquipo", this.getNombreEquipo());
            objEquipo.put("puntajeTotal", this.getPuntajeTotal());
            Iterator var3 = this.participantes.iterator();

            while(var3.hasNext()) {
                Participante p = (Participante)var3.next();
                arrayParticipantes.put(p.toJson());
            }

            objEquipo.put("participantes", arrayParticipantes);
        } catch (JSONException var5) {
            var5.printStackTrace();
        }

        return objEquipo;
    }
}
