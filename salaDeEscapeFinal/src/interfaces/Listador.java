package interfaces;

import models.Pista;

public interface Listador <T>{
    public boolean agregar(T obj);
    public boolean eliminar(T obj);
    public boolean buscar(T obj);
    public <T> T buscar(Integer id);
}
