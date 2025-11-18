// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import interfaces.IContrasenia;
import interfaces.IToJson;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

public class Participante extends Persona implements IContrasenia, IToJson {
    private String contrasenia;
    private Integer cantVidas = 3;
    private Integer puntaje = 0;
    public boolean Estado = true;

    public Participante(Integer id, String nombre, String contrasenia) {
        super(id, nombre);
        this.contrasenia = contrasenia;
    }

    public Participante(Integer id) {
        super(id);
        this.contrasenia = "";
    }

    public Participante() {
        this.contrasenia = "";
    }

    public Integer getCantVidas() {
        return this.cantVidas;
    }

    public void setCantVidas(Integer cantVidas) {
        this.cantVidas = cantVidas;
    }

    public Integer getPuntaje() {
        return this.puntaje;
    }

    private void setPuntaje(Integer puntaje) {
        this.puntaje = this.puntaje + puntaje;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void perderVida() {
        Integer var1 = this.cantVidas;
        this.cantVidas = this.cantVidas - 1;
    }

    public void ganarPuntos(int puntos) {
        this.puntaje = this.puntaje + puntos;
    }

    public boolean isActivo() {
        return this.Estado;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }

    public String responder(Prueba p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una respuesta: ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase(p.getRespuesta())) {
            this.ganarPuntos(100);
            return "Correcto";
        } else if (respuesta.equals("2")) {
            return "2";
        } else {
            String r;
            do {
                if (!respuesta.equals("1")) {
                    this.perderVida();
                    if (this.cantVidas == 0) {
                        this.setEstado(false);
                    }

                    return "Incorrecto";
                }

                System.out.println("PISTA - " + String.valueOf(p.getPistas()));
                System.out.println("Introduzca una respuesta: ");
                r = sc.nextLine();
            } while(!r.equalsIgnoreCase(p.getRespuesta()));

            this.ganarPuntos(100);
            return "Correcto";
        }
    }

    public boolean autenticar(String usuario, String contrasenia) {
        return usuario.equals(this.getNombre()) && contrasenia.equals(this.contrasenia);
    }

    public JSONObject toJson() {
        JSONObject objParticipante = new JSONObject();

        try {
            objParticipante.put("id", this.getId());
            objParticipante.put("nombre", this.getNombre());
            objParticipante.put("contrasenia", this.getContrasenia());
            objParticipante.put("cantVidas", this.getCantVidas());
            objParticipante.put("puntaje", this.getPuntaje());
            objParticipante.put("Estado", this.isActivo());
        } catch (JSONException var3) {
            var3.printStackTrace();
        }

        return objParticipante;
    }
}
