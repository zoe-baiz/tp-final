package gestoras;

import interfaces.IToJson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Sala implements IToJson<Sala> {
    private String nombre;
    private String historia;
    private ArrayList<Prueba> pruebas;
    private Integer id;
    private static int idGeneral=0;

    public Sala(String nombre, String historia) {
        this.nombre = nombre;
        this.historia = historia;
        this.pruebas=new ArrayList<>();
        this.id = ++idGeneral; ;
    }

    public Sala() {
        this.pruebas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static void setIdGeneral(int idGeneral) {
        Sala.idGeneral = idGeneral;
    }

    public static int getIdGeneral() {
        return idGeneral;
    }

    public Prueba getPruebas(int i) {
        return pruebas.get(i);
    }

    public ArrayList<Prueba> getPruebas() {
        return pruebas;
    }

    public boolean agregar(Prueba p){
        return pruebas.add(p);
    }

    public boolean eliminar(Prueba p){
        return pruebas.remove(p);
    }

    public boolean buscar(Prueba p){
        for(Prueba b : pruebas){
            if(b.equals(p)){
                return true;
            }
        }
        return false;
    }


    public Prueba buscar(Integer id) {
        Prueba p = new Prueba(id);
        for(Prueba b : pruebas){
            if(b.equals(p)){
                return b;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sala sala)) return false;
        return id.equals(sala.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("nombre", nombre);
            json.put("historia", historia);

            JSONArray pruebasArray = new JSONArray();
            for (Prueba p : pruebas) {
                pruebasArray.put(p.toJson());
            }
            json.put("pruebas", pruebasArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nombre='" + nombre + '\'' +
                ", historia='" + historia + '\'' +
                ", pruebas=" + pruebas +
                ", id=" + id +
                '}';
    }
}
