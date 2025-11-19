package models;

import gestoras.Equipo;
import gestoras.GestorSalas;
import gestoras.Sala;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static JSON.JsonUtiles.leer;

public class GestorJuego {
    private Equipo equipo;
    private GestorSalas salas;
    private Estado estado;

    public GestorJuego(Equipo equipo, GestorSalas salas) {
        this.equipo = equipo;
        this.salas = salas;
        this.estado=new Estado();
    }

    public GestorJuego() {
    }

    public GestorJuego(GestorSalas salas) {
        this.salas=salas;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setSalas(GestorSalas salas) {
        this.salas = salas;
    }

    public void iniciarJuego(int IndiceSala, int IndicePrueba) throws JSONException {

        if(this.estado == null){
            this.estado = new Estado();
        }

        int ISala = 0;
        for (Sala sala : salas.getLista().values()) {
            if (ISala < IndiceSala) {
                ISala++;
                continue;
            }

            System.out.println(sala.getHistoria());
            System.out.println("----");

            if (sala.getPruebas().isEmpty()) {
                ISala++;
                continue;
            }

            int IPrueba = IndicePrueba;
            for (Participante p : equipo.getLista().values()) {
                if (p.isActivo()) {
                    System.out.println("Turno--" + p.getNombre());
                    System.out.println("1 - Pedir pista ");
                    System.out.println("2 - Salir y Guardar Partida ");
                    System.out.println(sala.getPruebas(IPrueba).toString());
                    if (p.responder(sala.getPruebas(IPrueba)).equals("2")) {
                        estado.actualizarEstado(equipo, ISala, IPrueba, p.getCantVidas(), p.getPuntaje());
                        estado.guardarPartida(estado);
                        System.out.println("Partida guardada!");
                        return;
                    }
                }

                IPrueba++;
            }
        }

        System.out.println("Escapaste. Felicidades!!");

    }

    public void reanudar(String nombreEquipo,GestorSalas salasCargadas) throws JSONException {

        String file = "Partida";
        String jsonString = leer(file);

        if (jsonString == null || jsonString.isEmpty()) {
            System.out.println("No hay partidas guardadas aún.");
            return;
        }

        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject partidaObj = jsonArray.getJSONObject(i);

            JSONObject equipoInfo = partidaObj.getJSONObject("equipo");
            String nombreEquipoGuardado = equipoInfo.getString("nombreEquipo");

            if (nombreEquipoGuardado.equals(nombreEquipo)) {
                System.out.println("CARGANDO PARTIDA...");

                //  Reconstruir equipo
                int idEquipo = equipoInfo.getInt("id");
                Equipo equipoCargado = new Equipo(nombreEquipoGuardado);

                JSONArray participantesArray = equipoInfo.getJSONArray("participantes");

                for (int j = 0; j < participantesArray.length(); j++) {
                    JSONObject participanteObj = participantesArray.getJSONObject(j);

                    Participante participante = new Participante(
                            participanteObj.getInt("id"),
                            participanteObj.getString("nombre"),
                            participanteObj.getString("contrasenia")
                    );

                    participanteObj.getInt("puntaje");
                    participanteObj.getInt("cantVidas");
                    participanteObj.getBoolean("Estado");

                    participante.setCantVidas(participanteObj.getInt("cantVidas"));
                    participante.ganarPuntos(participanteObj.getInt("puntaje"));
                    participante.setEstado(participanteObj.getBoolean("Estado"));

                    equipoCargado.agregar(participante);
                }

                this.salas = salasCargadas;
                // volver al estadpo de juego
                Estado estadoCargado = new Estado();
                estadoCargado.actualizarEstado(
                        equipoCargado,
                        partidaObj.getInt("ISala"),
                        partidaObj.getInt("IPrueba"),
                        partidaObj.getInt("cantVidas"),
                        partidaObj.getInt("puntaje")
                );

                // acrtualizar juego
                this.equipo = equipoCargado;
                this.estado = estadoCargado;

                System.out.println("Partida encontrada. Continuando desde:");
                System.out.println("Sala: " + partidaObj.getInt("ISala"));
                System.out.println("Prueba: " + partidaObj.getInt("IPrueba"));

                iniciarJuego(partidaObj.getInt("ISala"), partidaObj.getInt("IPrueba"));
                return;
            }
        }

        System.out.println("No se encontró un equipo con ese nombre.");
    }

}
