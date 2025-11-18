package models;

public class SistemaPista {
    public Sala s;

    public SistemaPista(Sala s) {
        this.s = s;
    }

    public static String obtenerPista(Sala s, int i) {
        return s.getPruebas(i).getPistas().getTexto();
    }
}
