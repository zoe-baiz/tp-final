package models;

import gestoras.Equipo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static JSON.JsonUtiles.grabar;
import static JSON.JsonUtiles.leer;

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

    public JSONObject toJson(){
        JSONObject obj=new JSONObject();



        try {
            obj.put("equipo",equipo.toJson());
            obj.put("ISala",ISala);
            obj.put("IPrueba",IPrueba);
            obj.put("cantVidas",cantVidas);
            obj.put("puntaje",puntaje);

        }catch (JSONException e){
            e.printStackTrace();
        }

        return obj;
    }

    // models.Estado.java

    public void guardarPartida(Estado e) throws JSONException {
        JSONObject partidaJson = e.toJson();
        String file = "Partida.json"; // Usamos la extensión .json
        String nombreEquipoActual = e.getEquipo().getNombreEquipo();

        String jsonString = leer(file);
        JSONArray partidasGuardadas;

        try {
            // Cargar las partidas existentes, o un array vacío si no hay archivo
            partidasGuardadas = (jsonString == null || jsonString.isEmpty())
                    ? new JSONArray()
                    : new JSONArray(jsonString);
        } catch (JSONException ex) {
            // Manejar JSON corrupto
            partidasGuardadas = new JSONArray();
        }

        JSONArray nuevasPartidas = new JSONArray(); // Nueva lista limpia para el resultado
        boolean encontrada = false;

        // 1. Recorrer las partidas existentes
        for (int i = 0; i < partidasGuardadas.length(); i++) {
            JSONObject partida = partidasGuardadas.getJSONObject(i);
            JSONObject equipoJson = partida.getJSONObject("equipo");

            // Comparamos el nombre del equipo para ver si es la partida a actualizar
            if (equipoJson.getString("nombreEquipo").trim()
                    .equalsIgnoreCase(nombreEquipoActual.trim())) {

                // 2. Si el equipo existe (ACTUALIZAR):
                // Añadimos la NUEVA partida (la versión actualizada)
                nuevasPartidas.put(partidaJson);
                encontrada = true;

                // Omitimos la versión antigua.
            } else {
                // 3. Si es otro equipo, lo MANTENEMOS intacto.
                nuevasPartidas.put(partida);
            }
        }

        if (!encontrada) {
            // 4. Si el equipo NO fue encontrado (NUEVA PARTIDA):
            // La añadimos al final de la lista.
            nuevasPartidas.put(partidaJson);
        }

        // 5. Grabar la lista completa y actualizada.
        grabar(nuevasPartidas, file);

        // Mensaje de confirmación:
        if (encontrada) {
            System.out.println("🔄 Partida de " + nombreEquipoActual + " actualizada exitosamente.");
        } else {
            System.out.println("✅ Nueva partida para " + nombreEquipoActual + " guardada exitosamente.");
        }
    }
    @Override
    public String toString() {
        return "Estado{" +
                "equipo=" + equipo +
                ", ISala=" + ISala +
                ", IPrueba=" + IPrueba +
                ", cantVidas=" + cantVidas +
                ", puntaje=" + puntaje +
                '}';
    }
}
