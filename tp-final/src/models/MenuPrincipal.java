package models;

import gestoras.Equipo;
import gestoras.GestorSalas;
import org.json.JSONException;
import java.util.Scanner;

import static gestoras.Equipo.crearEquipo;

public class MenuPrincipal {

    Scanner sc;
    private GestorSalas salasCargadas;
    private Equipo equipo;


    public MenuPrincipal(Equipo equipo,GestorSalas salas) {
        sc = new Scanner(System.in);
        this.equipo=equipo;
        this.salasCargadas = salas;
    }

    public MenuPrincipal() {
        this(null, null);
    }


    public void mostrarMenu() throws JSONException {
        System.out.println(
                "1. Nueva partida " + "\n"+
                        "2. Cargar Partida "
        );

        String opcion = sc.nextLine();

        switch (opcion){
            case "1":
                iniciarJuego();
                break;
            case "2":
                System.out.println("Introduce el nombre de tu equipo: ");
                String equipoAsociado=sc.nextLine();
                reanudarJuego(equipoAsociado);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    // 3. 🌟 NUEVOS MÉTODOS AUXILIARES: Crean el GestorJuego con los datos

    private void iniciarJuego() throws JSONException {
        System.out.println("Pon un nombre a tu equipo: ");
        Equipo nuevoEquipo = crearEquipo();
        GestorJuego gJuego = new GestorJuego(nuevoEquipo, salasCargadas);

        gJuego.iniciarJuego(0,0);
    }

    private void reanudarJuego(String nombreEquipo) throws JSONException {
        GestorJuego gJuego = new GestorJuego();
        gJuego.reanudar(nombreEquipo,salasCargadas);
    }
}