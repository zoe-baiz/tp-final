// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import JSON.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestorJuego {
    private Equipo equipo;
    private GestorSalas salas;

    public GestorJuego(Equipo equipo, GestorSalas salas) {
        this.equipo = equipo;
        this.salas = salas;
    }

    public GestorJuego() {
    }

    public void iniciarJuego() {
        Estado estado = new Estado();

        for(int ISala = 0; ISala < this.salas.getSalas().size(); ++ISala) {
            Sala sala = (Sala)this.salas.getSalas().get(ISala);
            System.out.println(sala.getHistoria());
            System.out.println("----");
            if (!sala.getPruebas().isEmpty()) {
                int IPrueba = 0;

                for(int IParticipante = 0; IParticipante < this.equipo.getParticipantes().size(); ++IParticipante) {
                    Participante p = (Participante)this.equipo.getParticipantes().get(IParticipante);
                    if (p.isActivo()) {
                        System.out.println("Turno--" + p.getNombre());
                        System.out.println("1 - Pedir pista ");
                        System.out.println("2 - Salir y Guardar Partida ");
                        System.out.println(sala.getPruebas(IPrueba).toString());
                        if (p.responder(sala.getPruebas(IPrueba)).equals("2")) {
                            estado.actualizarEstado(this.equipo, ISala, IPrueba, p.getCantVidas(), p.getPuntaje());
                            break;
                        }
                    }

                    ++IPrueba;
                }
            }
        }

        Estado.guardarPartida(estado);
    }

    public void reanudar(String nombreEquipo) throws JSONException {
        String file = "partida";
        String jsonString = JsonUtiles.leer(file);
        if (jsonString != null) {
            JSONArray jsonArray = new JSONArray(jsonString);

            for(int i = 0; i < jsonArray.length(); ++i) {
                JSONObject partidaObj = jsonArray.getJSONObject(i);
                JSONObject equipoInfo = partidaObj.getJSONObject("equipo");
                String nombreEquipoGuardado = equipoInfo.getString("nombreEquipo");
                if (nombreEquipo.equalsIgnoreCase(nombreEquipoGuardado)) {
                    System.out.println("CARGANDO PARTIDA :)");
                    int idEquipo = equipoInfo.getInt("id");
                    Equipo equipoCargado = new Equipo(idEquipo, nombreEquipoGuardado);
                    JSONArray participantesArray = equipoInfo.getJSONArray("participantes");

                    int ISala;
                    int cantVidas;
                    int RSala;
                    for(ISala = 0; ISala < participantesArray.length(); ++ISala) {
                        JSONObject participanteObj = participantesArray.getJSONObject(ISala);
                        cantVidas = participanteObj.getInt("id");
                        String nombreParticipante = participanteObj.getString("nombre");
                        String contraseniaParticipante = participanteObj.getString("contrasenia");
                        RSala = participanteObj.getInt("puntaje");
                        int cantVidasParticipante = participanteObj.getInt("cantVidas");
                        boolean estadoParticipante = participanteObj.getBoolean("Estado");
                        Participante participante = new Participante(cantVidas, nombreParticipante, contraseniaParticipante);
                        participante.ganarPuntos(RSala);
                        participante.setCantVidas(cantVidasParticipante);
                        participante.setEstado(estadoParticipante);
                        equipoCargado.agregar(participante);
                    }

                    ISala = partidaObj.getInt("ISala");
                    int IPrueba = partidaObj.getInt("IPrueba");
                    cantVidas = partidaObj.getInt("cantVidas");
                    Estado estado = new Estado();
                    estado.actualizarEstado(equipoCargado, ISala, IPrueba, cantVidas, equipoCargado.getPuntajeTotal());
                    GestorSalas salas = new GestorSalas();

                    for(RSala = ISala; RSala < salas.getSalas().size(); ++RSala) {
                        Sala sala = (Sala)salas.getSalas().get(RSala);
                        System.out.println(sala.getHistoria());
                        System.out.println("----");
                        if (!sala.getPruebas().isEmpty()) {
                            int RIPrueba = 0;

                            for(int IParticipante = 0; IParticipante < equipoCargado.getParticipantes().size(); ++IParticipante) {
                                Participante p = (Participante)equipoCargado.getParticipantes().get(IParticipante);
                                if (p.isActivo()) {
                                    System.out.println("Turno--" + p.getNombre());
                                    System.out.println("1 - Pedir pista ");
                                    System.out.println("2 - Salir y Guardar Partida ");
                                    System.out.println(sala.getPruebas(RIPrueba).toString());
                                    if (p.responder(sala.getPruebas(RIPrueba)).equals("2")) {
                                        estado.actualizarEstado(equipoCargado, RSala, RIPrueba, p.getCantVidas(), p.getPuntaje());
                                        break;
                                    }
                                }

                                ++RIPrueba;
                            }
                        }
                    }

                    Estado.guardarPartida(estado);
                    return;
                }
            }

            System.out.println("El nombre del equipo no coincide con el equipo guardado.");
        }

    }
}
