// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import enums.TipoDePrueba;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestorSalas {
    private ArrayList<Sala> salas = new ArrayList();

    public GestorSalas() {
    }

    public boolean agregar(Sala s) {
        return s != null ? this.salas.add(s) : false;
    }

    public ArrayList<Sala> getSalas() {
        return this.salas;
    }

    public String toString() {
        return "GestorSalas{salas=" + String.valueOf(this.salas) + "}";
    }

    public JSONObject toJson() {
        JSONArray jsonArray = new JSONArray();
        Iterator var2 = this.salas.iterator();

        while(var2.hasNext()) {
            Sala s = (Sala)var2.next();
            jsonArray.put(s.toJson());
        }

        JSONObject json = new JSONObject();

        try {
            json.put("salas", jsonArray);
        } catch (JSONException var4) {
            var4.printStackTrace();
        }

        return json;
    }

    public boolean guardarComoJson(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);

            boolean var3;
            try {
                fw.write(this.toJson().toString());
                var3 = true;
            } catch (Throwable var6) {
                try {
                    fw.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            fw.close();
            return var3;
        } catch (IOException var7) {
            System.out.println("❌ Error guardando JSON: " + var7.getMessage());
            return false;
        }
    }

    public void fromJson(JSONObject json) throws JSONException {
        JSONArray salasArray = json.getJSONArray("salas");

        for(int i = 0; i < salasArray.length(); ++i) {
            JSONObject salaJson = salasArray.getJSONObject(i);
            Sala sala = new Sala();
            sala.setNombre(salaJson.getString("nombre"));
            sala.setHistoria(salaJson.getString("historia"));
            JSONArray pruebasArray = salaJson.getJSONArray("pruebas");

            for(int j = 0; j < pruebasArray.length(); ++j) {
                JSONObject pruebaJson = pruebasArray.getJSONObject(j);
                Prueba prueba = new Prueba(pruebaJson.getString("nombre"), pruebaJson.getString("descripcion"), TipoDePrueba.valueOf(pruebaJson.getString("tipo")), pruebaJson.getInt("id"), pruebaJson.getString("respuesta"));
                JSONArray pistasArray = pruebaJson.getJSONArray("pistas");

                for(int k = 0; k < pistasArray.length(); ++k) {
                    JSONObject pistaJson = pistasArray.getJSONObject(k);
                    Pista pista = new Pista(pistaJson.getInt("id"), pistaJson.getString("texto"));
                    prueba.agregar(pista);
                }

                sala.agregar(prueba);
            }

            this.agregar(sala);
        }

    }
}
