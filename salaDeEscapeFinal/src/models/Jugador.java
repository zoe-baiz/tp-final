package models;

import java.util.Scanner;

public class Jugador extends Persona{
    private String nombre;
    private int cantVidas = 3;
    private int puntaje = 0;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";


    public Jugador(Integer id, String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVidas() {
        return cantVidas;
    }

    private void setCantVidas(Integer cantVidas) {
        this.cantVidas = cantVidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    private void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public boolean responderPrueba(Jugador j,Prueba p){
        Scanner sc=new Scanner(System.in);
        System.out.println(ANSI_RESET +p.toString()+ANSI_RESET );
        System.out.println("Respuesta prueba: ");
        String respuesta=sc.nextLine();
        if(respuesta.equals(p.getRespuesta())){
            System.out.println(ANSI_GREEN+"Bien"+ANSI_GREEN);
            j.puntaje += 100;
            return true;
        }else{
            System.out.println(ANSI_RED+"Mal"+ANSI_RED);
            j.cantVidas--;
        }


        return false;
    }

}
