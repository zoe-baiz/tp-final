package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;

import static JSON.JsonUtiles.grabar;

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
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getISala() {
        return ISala;
    }

    public void setISala(int ISala) {
        this.ISala = ISala;
    }

    public int getIPrueba() {
        return IPrueba;
    }

    public void setIPrueba(int IPrueba) {
        this.IPrueba = IPrueba;
    }

    public int getCantVidas() {
        return cantVidas;
    }

    public void setCantVidas(int cantVidas) {
        this.cantVidas = cantVidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public  void actualizarEstado(Equipo equipo, int ISala, int IPrueba, int cantVidas, int puntaje){
        setEquipo(equipo);
        setISala(ISala);
        setIPrueba(IPrueba);
        setCantVidas(cantVidas);
        setPuntaje(puntaje);
    }

    public JSONArray toJson(){
        JSONArray arrayPartidas=new JSONArray();
        JSONObject obj=new JSONObject();

        JSONArray arrayParticipantes=new JSONArray();
        JSONObject objParticipantes=new JSONObject();

        try {
            for(Participante p:equipo.getParticipantes()){

            }
        obj.put("equipo",getEquipo().toJson());
        obj.put("ISala",getISala());
        obj.put("IPrueba",getIPrueba());
        obj.put("cantVidas",getCantVidas());
        obj.put("puntaje",getPuntaje());

        arrayPartidas.put(obj);
        }catch (JSONException e){
            e.printStackTrace();
        }

        return arrayPartidas;
    }

    public static void guardarPartida(Estado e){
        JSONArray arrayEstado = e.toJson();
        grabar(arrayEstado,"Partida.json");
    }
}
