package exceptions;

public class ParticipanteNoExisteException extends Exception {
    public ParticipanteNoExisteException(String message) {
        super(message);
    }

    public ParticipanteNoExisteException() {    }
}
