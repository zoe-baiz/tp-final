package exceptions;

public class EquipoYaExisteException extends Exception {
    public EquipoYaExisteException(String nombre) {
        super("Ya existe un equipo con el nombre: " + nombre);
    }

    public EquipoYaExisteException() {}
}