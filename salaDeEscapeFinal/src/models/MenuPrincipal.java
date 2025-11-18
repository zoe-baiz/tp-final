// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import java.util.Scanner;
import org.json.JSONException;

public class MenuPrincipal {
    Scanner sc;
    GestorJuego gJuego;

    public MenuPrincipal() {
        this.sc = new Scanner(System.in);
        this.gJuego = new GestorJuego();
    }

    public void mostrarMenu() throws JSONException {
        System.out.println("1. Nueva partida \n2. Cargar Partida ");
        switch (this.sc.nextLine()) {
            case "1":
                this.gJuego.iniciarJuego();
                break;
            case "2":
                this.gJuego.reanudar("nombre");
                break;
            default:
                System.out.printf("opcion no valida");
        }

    }
}
