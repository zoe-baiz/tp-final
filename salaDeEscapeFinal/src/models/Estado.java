// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import JSON.JsonUtiles;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Estado {
    public Equipo equipo;
    public int ISala;
    public int IPrueba;
    public int cantVidas;
    public int puntaje;

    public Estado(Equipo equipo, int ISala, int IPrueba, int cantVidas, int puntaje) {
        this.equipo = equipo;
        this.ISala = ISala;
        this.IPrueba = IPrueba;
        this.cantVidas = cantVidas;
        this.puntaje = puntaje;
    }

    public Estado() {
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getISala() {
        return this.ISala;
    }

    public void setISala(int ISala) {
        this.ISala = ISala;
    }

    public int getIPrueba() {
        return this.IPrueba;
    }

    public void setIPrueba(int IPrueba) {
        this.IPrueba = IPrueba;
    }

    public int getCantVidas() {
        return this.cantVidas;
    }

    public void setCantVidas(int cantVidas) {
        this.cantVidas = cantVidas;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void actualizarEstado(Equipo equipo, int ISala, int IPrueba, int cantVidas, int puntaje) {
        this.setEquipo(equipo);
        this.setISala(ISala);
        this.setIPrueba(IPrueba);
        this.setCantVidas(cantVidas);
        this.setPuntaje(puntaje);
    }

    public JSONArray toJson() {
        JSONArray arrayPartidas = new JSONArray();
        JSONObject obj = new JSONObject();
        new JSONArray();
        new JSONObject();

        try {
            Participante var6;
            for(Iterator var5 = this.equipo.getParticipantes().iterator(); var5.hasNext(); var6 = (Participante)var5.next()) {
            }

            obj.put("equipo", this.getEquipo().toJson());
            obj.put("ISala", this.getISala());
            obj.put("IPrueba", this.getIPrueba());
            obj.put("cantVidas", this.getCantVidas());
            obj.put("puntaje", this.getPuntaje());
            arrayPartidas.put(obj);
        } catch (JSONException var7) {
            var7.printStackTrace();
        }

        return arrayPartidas;
    }

    public static void guardarPartida(Estado e) {
        JSONArray arrayEstado = e.toJson();
        JsonUtiles.grabar(arrayEstado, "Partida.json");
    }
}
