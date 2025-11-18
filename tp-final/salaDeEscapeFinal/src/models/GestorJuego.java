package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static JSON.JsonUtiles.grabar;
import static JSON.JsonUtiles.leer;
import static models.Estado.guardarPartida;

public class GestorJuego {
    private Equipo equipo;
    private GestorSalas salas;

    public GestorJuego(Equipo equipo, GestorSalas salas) {
        this.equipo = equipo;
        this.salas = salas;
    }

    public GestorJuego() {
    }

    public void iniciarJuego(){

        Estado estado=new Estado();


        for(int ISala=0;ISala<salas.getSalas().size();ISala++){
            Sala sala = salas.getSalas().get(ISala);

            System.out.println(sala.getHistoria());
            System.out.println("----");

            if(sala.getPruebas().isEmpty()){
                continue;
            }

            int IPrueba=0;
            for (int IParticipante=0;IParticipante<equipo.getParticipantes().size();IParticipante++) {
                Participante p = equipo.getParticipantes().get(IParticipante);
                if (p.isActivo()) {
                    System.out.println("Turno--" + p.getNombre());
                    System.out.println("1 - Pedir pista ");
                    System.out.println("2 - Salir y Guardar Partida ");
                    System.out.println(sala.getPruebas(IPrueba).toString());
                    if(p.responder(sala.getPruebas(IPrueba)).equals("2")){
                        estado.actualizarEstado(equipo,ISala,IPrueba,p.getCantVidas(),p.getPuntaje());
                        break;
                    }
                }
                IPrueba++;
            }
        }
        guardarPartida(estado);

    }


    public void reanudar(String nombreEquipo) throws JSONException {
        String file = "partida";
        String jsonString = leer(file);  // Leer el archivo JSON

        if (jsonString != null) {
            JSONArray jsonArray = new JSONArray(jsonString);

            // Buscar si el nombre del equipo está en el archivo JSON
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject partidaObj = jsonArray.getJSONObject(i);

                // Extraer la información del equipo guardado
                JSONObject equipoInfo = partidaObj.getJSONObject("equipo");
                String nombreEquipoGuardado = equipoInfo.getString("nombreEquipo");

                // Verificar si el nombre del equipo guardado coincide con el solicitado
                if (nombreEquipo.equalsIgnoreCase(nombreEquipoGuardado)) {
                    System.out.println("CARGANDO PARTIDA :)");

                    // Obtener el ID del equipo (puede que necesites usarlo después)
                    int idEquipo = equipoInfo.getInt("id");

                    // Crear un nuevo equipo con el mismo nombre
                    Equipo equipoCargado = new Equipo(idEquipo, nombreEquipoGuardado);

                    // Extraer los participantes del equipo guardado
                    JSONArray participantesArray = equipoInfo.getJSONArray("participantes");
                    for (int j = 0; j < participantesArray.length(); j++) {
                        JSONObject participanteObj = participantesArray.getJSONObject(j);

                        int idParticipante = participanteObj.getInt("id");
                        String nombreParticipante = participanteObj.getString("nombre");
                        String contraseniaParticipante = participanteObj.getString("contrasenia");
                        int puntajeParticipante = participanteObj.getInt("puntaje");
                        int cantVidasParticipante = participanteObj.getInt("cantVidas");
                        boolean estadoParticipante = participanteObj.getBoolean("Estado");

                        // Crear un nuevo participante con los datos cargados
                        Participante participante = new Participante(idParticipante, nombreParticipante, contraseniaParticipante);
                        participante.ganarPuntos(puntajeParticipante);
                        participante.setCantVidas(cantVidasParticipante);
                        participante.setEstado(estadoParticipante);

                        // Agregar el participante al equipo cargado
                        equipoCargado.agregar(participante);
                    }

                    // Obtener el estado de la sala y la prueba desde el JSON
                    int ISala = partidaObj.getInt("ISala");
                    int IPrueba = partidaObj.getInt("IPrueba");
                    int cantVidas = partidaObj.getInt("cantVidas");

                    // Crear un objeto Estado para cargar el estado actual del juego
                    Estado estado = new Estado();
                    estado.actualizarEstado(equipoCargado, ISala, IPrueba, cantVidas, equipoCargado.getPuntajeTotal());

                    // Ahora, continúa con la reanudación del juego desde la sala y la prueba guardadas
                    GestorSalas salas = new GestorSalas();  // Asumiendo que tienes una forma de obtener las salas
                    for (int RSala = ISala; RSala < salas.getSalas().size(); RSala++) {
                        Sala sala = salas.getSalas().get(RSala);
                        System.out.println(sala.getHistoria());
                        System.out.println("----");

                        if (sala.getPruebas().isEmpty()) {
                            continue;
                        }

                        int RIPrueba = 0;
                        for (int IParticipante = 0; IParticipante < equipoCargado.getParticipantes().size(); IParticipante++) {
                            Participante p = equipoCargado.getParticipantes().get(IParticipante);
                            if (p.isActivo()) {
                                System.out.println("Turno--" + p.getNombre());
                                System.out.println("1 - Pedir pista ");
                                System.out.println("2 - Salir y Guardar Partida ");
                                System.out.println(sala.getPruebas(RIPrueba).toString());

                                // Asumimos que el método 'responder' puede devolver "2" cuando el jugador quiere salir
                                if (p.responder(sala.getPruebas(RIPrueba)).equals("2")) {
                                    estado.actualizarEstado(equipoCargado, RSala, RIPrueba, p.getCantVidas(), p.getPuntaje());
                                    break;
                                }
                            }
                            RIPrueba++;
                        }
                    }

                    // Guardar el estado actualizado de la partida
                    guardarPartida(estado);
                    return;  // Salir después de encontrar y cargar el equipo
                }
            }

            // Si el equipo no se encuentra en el JSON
            System.out.println("El nombre del equipo no coincide con el equipo guardado.");
        }
    }



}
