package estDat.estDatLin;


/**
 * Write a description of interface Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Lista<T>{
    boolean vacia();
    void insertar(T dato);
    void insertar(T dato, int pos);
    void insertarIni(T dato);
    T eliminar(int pos);
    T eliminar(T dato);
    void eliminar(int desde, int hasta);
    void eliminarTodas(T dato);
    T acceder(int pos);
    T acceder(T dato);
    Lista<T> acceder(int desde, int hasta);
    int longitud();
    boolean buscar(T dato);
    int indiceDe(T dato);
}
