package exceptions;

public class ParticipanteYaExisteException extends Exception {
    public ParticipanteYaExisteException(String nombre) {
        super("El participante '" + nombre + "' ya está registrado.");
    }

    public ParticipanteYaExisteException() {}
}