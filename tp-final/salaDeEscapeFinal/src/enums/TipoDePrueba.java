package enums;

public enum TipoDePrueba {
    LOGICA(1),
    CAOS(2),
    RECUERDO(3),
    CREATIVIDAD(4);

    private int value;

    TipoDePrueba(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
