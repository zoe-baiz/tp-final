package gestoras;

import enums.TipoDePrueba;
import models.Pista;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class GestorSalas extends Gestor<Sala> {

    public GestorSalas() {
        super();
    }

    @Override
    public boolean eliminar(Sala j){
        if (getLista().remove(j) != null) return true;
        else return false;
    }

    @Override
    public Sala eliminar(Integer ID) {
        return getLista().remove(ID);
    }

    @Override
    public boolean agregar(Sala p){
        return getLista().put(p.getId(), p) == null;
    }

    @Override
    public Sala buscar(Integer ID) {
        return getLista().get(ID);  // fácil, directo
    }

    @Override
    public boolean buscar(Sala obj) {
        return getLista().containsValue(obj);
    }


    @Override
    public String toString() {
        return "GestorSalas{" +
                "salas=" + getLista().toString() +
                '}';
    }


    //Metodos para serialzar y deserializar

    public JSONObject toJson() throws JSONException {
        JSONArray jsonArray = new JSONArray();

        for (Sala s : getLista().values()) {
            jsonArray.put(s.toJson());
        }

        JSONObject json = new JSONObject();
        json.put("salas", jsonArray);
        return json;
    }


    public boolean guardarComoJson(String ruta){
        try(FileWriter fw = new FileWriter(ruta)){
            fw.write(toJson().toString());
            return true;
        } catch(IOException | JSONException e){
            System.out.println("Error guardando JSON: " + e.getMessage());
            return false;
        }
    }

    public void fromJson(JSONObject json) throws JSONException {
        JSONArray salasArray = json.getJSONArray("salas");

        for (int i = 0; i < salasArray.length(); i++) {
            JSONObject salaJson = salasArray.getJSONObject(i);

            Sala sala = new Sala();
            sala.setNombre(salaJson.getString("nombre"));
            sala.setHistoria(salaJson.getString("historia"));
            sala.setId(salaJson.getInt("id"));


            JSONArray pruebasArray = salaJson.getJSONArray("pruebas");

            for (int j = 0; j < pruebasArray.length(); j++) {
                JSONObject pruebaJson = pruebasArray.getJSONObject(j);

                Prueba prueba = new Prueba(
                        pruebaJson.getString("nombre"),
                        pruebaJson.getString("descripcion"),
                        TipoDePrueba.valueOf(pruebaJson.getString("tipo")),
                        pruebaJson.getInt("id"),
                        pruebaJson.getString("respuesta")
                );

                JSONArray pistasArray = pruebaJson.getJSONArray("pistas");

                for (int k = 0; k < pistasArray.length(); k++) {
                    JSONObject pistaJson = pistasArray.getJSONObject(k);

                    Pista pista = new Pista(
                            pistaJson.getInt("id"),
                            pistaJson.getString("texto")
                    );

                    prueba.agregar(pista);
                }

                sala.agregar(prueba);
            }

            agregar(sala);
        }
    }

}
