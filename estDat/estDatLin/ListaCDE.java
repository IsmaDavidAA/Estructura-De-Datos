package estDat.estDatLin;


/**
 * Write a description of class ListaCDE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCDE<T> implements Lista<T>{
    
    private NodoDE<T> ini;

    public boolean vacia(){
        return ini == null;
    }
    public void insertar(T dato){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        NodoDE<T> aux;
        if(vacia()){
            ini = nuevo;
            ini.setSuc(ini);
            ini.setAnt(ini);
        }else{
            aux = ini;
            while(aux.getSuc() != ini){
                aux = aux.getSuc();
            }
            nuevo.setAnt(aux);
            nuevo.setSuc(ini);
            aux.setSuc(nuevo);
            ini.setAnt(nuevo);
        }
    }
    public void insertar(T dato, int pos){
        
    }
    public void insertarIni(T dato){
    }
    public T eliminar(int pos){
        return null;
    }
    public T eliminar(T dato){
        return null;
    }
    public void eliminar(int desde, int hasta){
    }
    public void eliminarTodas(T dato){
    }
    public T acceder(int pos){
        return null;
    }
    public T acceder(T dato){
        return null;
    }
    public Lista<T> acceder(int desde, int hasta){
        return null;
    }
    public int longitud(){
        return 0;
    }
    public boolean buscar(T dato){
        return false;
    }
    public int indiceDe(T dato){
        return 0;
    }
}
