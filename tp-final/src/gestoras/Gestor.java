package gestoras;

import java.util.TreeMap;

public abstract class Gestor <T>{
    private TreeMap<Integer,T> lista;

    public Gestor() {
        lista = new TreeMap<>();
    }

    public TreeMap<Integer, T> getLista() {
        return lista;
    }

    public void setLista(TreeMap<Integer, T> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Gestor{" +
                "lista=" + lista +
                '}';
    }

    public abstract boolean agregar(T obj);
    public abstract <T> T buscar(Integer ID);
    public abstract boolean buscar(T obj);
    public abstract boolean eliminar(T obj);
    public abstract <T> T eliminar(Integer ID);
}
