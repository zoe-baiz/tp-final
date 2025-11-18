    package models;

    import org.json.JSONException;
    import java.util.Scanner;

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
                    iniciarJuego(); // Llama al método auxiliar que contiene la lógica
                    break;
                case "2":
                    reanudarJuego("nombre");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        // 3. 🌟 NUEVOS MÉTODOS AUXILIARES: Crean el GestorJuego con los datos

        private void iniciarJuego() {

            GestorJuego gJuego = new GestorJuego(equipo, salasCargadas);

            gJuego.iniciarJuego();
        }

        private void reanudarJuego(String nombreEquipo) throws JSONException {


            GestorJuego gJuego = new GestorJuego();
            gJuego.reanudar(equipo.getNombreEquipo());
        }
    }