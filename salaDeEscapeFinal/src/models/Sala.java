// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import interfaces.IToJson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Sala implements IToJson<Sala> {
    private String nombre;
    private String historia;
    private ArrayList<Prueba> pruebas;
    private Integer id;
    private static int idGeneral = 0;

    public Sala(String nombre, String historia) {
        this.nombre = nombre;
        this.historia = historia;
        this.pruebas = new ArrayList();
        idGeneral = idGeneral++;
        this.id = idGeneral;
    }

    public Sala() {
        this.pruebas = new ArrayList();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHistoria() {
        return this.historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Integer getId() {
        return this.id;
    }

    public static int getIdGeneral() {
        return idGeneral;
    }

    public Prueba getPruebas(int i) {
        return (Prueba)this.pruebas.get(i);
    }

    public ArrayList<Prueba> getPruebas() {
        return this.pruebas;
    }

    public boolean agregar(Prueba p) {
        return this.pruebas.add(p);
    }

    public boolean eliminar(Prueba p) {
        return this.pruebas.remove(p);
    }

    public boolean buscar(Prueba p) {
        Iterator var2 = this.pruebas.iterator();

        Prueba b;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            b = (Prueba)var2.next();
        } while(!b.equals(p));

        return true;
    }

    public Prueba buscar(Integer id) {
        Prueba p = new Prueba(id);
        Iterator var3 = this.pruebas.iterator();

        Prueba b;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            b = (Prueba)var3.next();
        } while(!b.equals(p));

        return b;
    }

    public boolean equals(Object o) {
        if (o instanceof Sala sala) {
            return this.id.equals(sala.getId());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        try {
            json.put("id", this.id);
            json.put("nombre", this.nombre);
            json.put("historia", this.historia);
            JSONArray pruebasArray = new JSONArray();
            Iterator var3 = this.pruebas.iterator();

            while(var3.hasNext()) {
                Prueba p = (Prueba)var3.next();
                pruebasArray.put(p.toJson());
            }

            json.put("pruebas", pruebasArray);
        } catch (JSONException var5) {
            var5.printStackTrace();
        }

        return json;
    }
}
