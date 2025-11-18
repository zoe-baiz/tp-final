package enums;

public enum tipoDePrueba {
    LOGICA(1),
    CAOS(2),
    RECUERDO(3),
    CREATIVIDAD(4);

    private int value;

    tipoDePrueba(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
