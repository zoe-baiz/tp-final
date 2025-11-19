package gestoras;

import interfaces.IToJson;
import models.Participante;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.Scanner;

public class Equipo extends Gestor<Participante> implements IToJson {
    private String nombreEquipo;
    private Integer puntajeTotal;
    private Integer id;
    private static Integer idGeneral = 0;

    public Equipo(String nombreEquipo) {
        super();
        this.nombreEquipo = nombreEquipo;
        this.puntajeTotal = 0;
        this.id = ++idGeneral; // CORREGIDO
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if (id > idGeneral) idGeneral = id; // ← mantiene consistencia
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Integer getPuntajeTotal() {
        int sum = 0;

        for (Participante p : getLista().values()) {   // CORREGIDO
            sum += p.getPuntaje();
        }

        this.puntajeTotal = sum;
        return sum;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    @Override
    public boolean eliminar(Participante j){
        return getLista().remove(j.getId()) != null;   // CORREGIDO
    }

    @Override
    public Participante eliminar(Integer ID) {
        return getLista().remove(ID);
    }

    @Override
    public boolean agregar(Participante p){
        return getLista().put(p.getId(), p) == null;  // CORRECTO
    }

    @Override
    public Participante buscar(Integer ID) {
        return getLista().get(ID);    // CORRECTO
    }

    @Override
    public boolean buscar(Participante obj) {
        return getLista().containsValue(obj);
    }

    @Override
    public JSONObject toJson() {
        JSONObject objEquipo = new JSONObject();
        JSONArray arrayParticipantes = new JSONArray();

        try {
            objEquipo.put("id", getId());
            objEquipo.put("nombreEquipo", getNombreEquipo());
            objEquipo.put("puntajeTotal", getPuntajeTotal());

            for (Participante p : getLista().values()) {   // CORREGIDO
                arrayParticipantes.put(p.toJson());
            }

            objEquipo.put("participantes", arrayParticipantes);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return objEquipo;
    }

    public static Equipo crearEquipo() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();

        while(nombreEquipo.isBlank()){
            System.out.println("El nombre no puede estar vacío. Intente nuevamente.");
            nombreEquipo = scanner.nextLine();
        }

        Equipo nuevoEquipo = new Equipo(nombreEquipo);

        System.out.print("¿Cuántos participantes tendrá el equipo?: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i <= cantidad; i++){
            System.out.print("\nIngrese el nombre del participante " + i + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la contraseña del participante: ");
            String contrasenia = scanner.nextLine();

            Participante p = new Participante(i, nombre, contrasenia);
            nuevoEquipo.agregar(p);
        }

        System.out.println("Equipo creado exitosamente: " + nuevoEquipo.getNombreEquipo() + "\n");

        return nuevoEquipo;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", participantes=" + getLista().values() +
                ", puntajeTotal=" + puntajeTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equipo equipo)) return false;
        return Objects.equals(nombreEquipo, equipo.nombreEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreEquipo);
    }
}
