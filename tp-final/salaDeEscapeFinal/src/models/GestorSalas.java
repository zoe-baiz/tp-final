package models;

import enums.TipoDePrueba;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorSalas {
    private ArrayList<Sala> salas;

    public GestorSalas() {
        this.salas=new ArrayList<>();
    }

    public boolean agregar(Sala s){
        if(s!=null){
            return  salas.add(s);
        }

        return  false;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    @Override
    public String toString() {
        return "GestorSalas{" +
                "salas=" + salas +
                '}';
    }


    //Metodos para serialzar y deserializar

    public JSONObject toJson(){
        JSONArray jsonArray = new JSONArray();
        for(Sala s : salas){
            jsonArray.put(s.toJson());
        }

        JSONObject json = new JSONObject();
        try {
            json.put("salas", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }


    public boolean guardarComoJson(String ruta){
        try(FileWriter fw = new FileWriter(ruta)){
            fw.write(toJson().toString());
            return true;
        } catch(IOException e){
            System.out.println("❌ Error guardando JSON: " + e.getMessage());
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
