// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package models;

import enums.TipoDePrueba;
import interfaces.Listador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Prueba implements Listador<Pista> {
    private Integer id;
    private String nombre;
    private String descripcion;
    private TipoDePrueba tipo;
    private String respuesta;
    private ArrayList<Pista> pistas;

    public Prueba(String nombre, String descripcion, TipoDePrueba tipo, Integer id, String respuesta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.respuesta = respuesta;
        this.pistas = new ArrayList();
    }

    public Prueba(Integer id) {
        this.nombre = "";
        this.descripcion = "";
        this.tipo = TipoDePrueba.LOGICA;
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDePrueba getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoDePrueba tipo) {
        this.tipo = tipo;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public Pista getPistas() {
        int min = 0;
        int max = this.pistas.size();
        int indiceAleatorio = (int)(Math.random() * (double)(max - min) + (double)min);
        Pista pista = (Pista)this.pistas.get(indiceAleatorio);
        this.pistas.remove(indiceAleatorio);
        return pista;
    }

    public boolean agregar(Pista p) {
        return this.pistas.add(p);
    }

    public boolean eliminar(Pista p) {
        return this.pistas.remove(p);
    }

    public boolean buscar(Pista p) {
        Iterator var2 = this.pistas.iterator();

        Pista b;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            b = (Pista)var2.next();
        } while(!b.equals(p));

        return true;
    }

    public Pista buscar(Integer id) {
        Pista p = new Pista(id);
        Iterator var3 = this.pistas.iterator();

        Pista b;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            b = (Pista)var3.next();
        } while(!b.equals(p));

        return b;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        try {
            json.put("id", this.id);
            json.put("nombre", this.nombre);
            json.put("descripcion", this.descripcion);
            json.put("tipo", this.tipo.toString());
            json.put("respuesta", this.respuesta);
            JSONArray pistasArray = new JSONArray();
            Iterator var3 = this.pistas.iterator();

            while(var3.hasNext()) {
                Pista p = (Pista)var3.next();
                pistasArray.put(p.toJson());
            }

            json.put("pistas", pistasArray);
        } catch (JSONException var5) {
            var5.printStackTrace();
        }

        return json;
    }

    public boolean equals(Object o) {
        if (o instanceof Prueba prueba) {
            return this.id.equals(prueba.getId());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    public String toString() {
        return "Nombre='" + this.nombre + "\nDescripcion='" + this.descripcion;
    }
}
