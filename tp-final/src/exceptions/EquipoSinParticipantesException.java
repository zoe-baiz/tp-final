package exceptions;

public class EquipoSinParticipantesException extends Exception {
    public EquipoSinParticipantesException(String nombreEquipo) {
        super("El equipo '" + nombreEquipo + "' no tiene participantes registrados.");
    }

    public EquipoSinParticipantesException() {}
}
