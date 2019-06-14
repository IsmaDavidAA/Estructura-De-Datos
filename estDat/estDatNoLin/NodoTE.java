package estDat.estDatNoLin;


public class NodoTE<T>{

    private NodoTE<T> padre;
    private NodoTE<T> hijo;
    private NodoTE<T> hno;
    private T dato;
    public NodoTE(){
        padre = hijo = hno = null;
        dato = null;
    }

    public boolean vacia(){
        return dato == null;
    }
    
    
}
