package models;

import gestoras.Prueba;
import interfaces.IContrasenia;
import interfaces.IToJson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class Participante extends Persona implements IContrasenia, IToJson {
    private String contrasenia;
    private Integer cantVidas = 3;
    private Integer puntaje = 0;
    public boolean Estado=true;

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
        return cantVidas;
    }

    public void setCantVidas(Integer cantVidas) {
        this.cantVidas = cantVidas;

    }

    public Integer getPuntaje() {
        return puntaje;
    }

    private void setPuntaje(Integer puntaje) {
        this.puntaje += puntaje;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void perderVida(){
        this.cantVidas--;
    }

    public void ganarPuntos(int puntos){
        this.puntaje += puntos;
    }

    public boolean isActivo() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public String responder(Prueba p){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca una respuesta: ");
        String respuesta = sc.nextLine();

        if(respuesta.equalsIgnoreCase(p.getRespuesta())){
            this.ganarPuntos(100);
            return "Correcto";
        }else if(respuesta.equals("2")){
            return "2";
        }

        while(respuesta.equals("1")){
            System.out.println("PISTA - " + p.getPistas());

            System.out.println("Introduzca una respuesta: ");
            String r = sc.nextLine();

            if(r.equalsIgnoreCase(p.getRespuesta())){
                this.ganarPuntos(100);
                return "Correcto";
            }
        }

        this.perderVida();

        if(cantVidas == 0){
            setEstado(false);
        }

        return "Incorrecto";
    }



    @Override
    public boolean autenticar(String usuario, String contrasenia) {
        if(usuario.equals(this.getNombre()) && contrasenia.equals(this.contrasenia)) return true;
        return false;
    }

    @Override
    public JSONObject toJson() {
        JSONObject objParticipante=new JSONObject();

        try{
            objParticipante.put("id", getId());
            objParticipante.put("nombre", getNombre());
            objParticipante.put("contrasenia",getContrasenia());
            objParticipante.put("cantVidas",getCantVidas());
            objParticipante.put("puntaje",getPuntaje());
            objParticipante.put("Estado",isActivo());
        }catch (JSONException e){
            e.printStackTrace();
        }

        return objParticipante;
    }

    @Override
    public String toString() {
        return "Participante{" +
                super.toString()+
                "cantVidas=" + cantVidas +
                ", puntaje=" + puntaje +
                ", Estado=" + Estado +
                '}';
    }
}
