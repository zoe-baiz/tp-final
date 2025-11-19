package gestoras;

import enums.TipoDePrueba;
import models.Pista;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Prueba {
    private Integer id;
    private String nombre;
    private String descripcion;
    private TipoDePrueba tipo;
    private String respuesta;
    private ArrayList<Pista> pistas;

    public Prueba(String nombre, String descripcion, TipoDePrueba tipo, Integer id,String respuesta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.respuesta=respuesta;
        this.pistas=new ArrayList<>();
    }

    public Prueba(Integer id) {
        this.nombre = "";
        this.descripcion = "";
        this.tipo = TipoDePrueba.LOGICA;
        this.id = id;
    }
    /*
        public Prueba() {
            this.nombre = "";
            this.descripcion = "";
            this.tipo = TipoDePrueba.LOGICA;
            this.id = -1;
        }
        */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDePrueba getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePrueba tipo) {
        this.tipo = tipo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public Pista getPistas() {
        int min = 0;
        int max = pistas.size();
        int indiceAleatorio = (int) (Math.random() * (max - min) + min);
        Pista pista = pistas.get(indiceAleatorio);
        pistas.remove(indiceAleatorio);
        return pista;
    }

    public boolean agregar(Pista p){
        return pistas.add(p);
    }

    public boolean eliminar(Pista p){
        return pistas.remove(p);
    }

    public boolean buscar(Pista p){
        for(Pista b : pistas){
            if(b.equals(p)){
                return true;
            }
        }
        return false;
    }

    public Pista buscar(Integer id) {
        Pista p = new Pista(id);
        for(Pista b : pistas){
            if(b.equals(p)){
                return b;
            }
        }
        return null;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("nombre", nombre);
            json.put("descripcion", descripcion);
            json.put("tipo", tipo.toString());
            json.put("respuesta", respuesta);

            JSONArray pistasArray = new JSONArray();
            for (Pista p : pistas){
                pistasArray.put(p.toJson());
            }
            json.put("pistas", pistasArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Prueba prueba)) return false;
        return id.equals(prueba.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\n' +
                "Descripcion='" + descripcion ;
    }
}
