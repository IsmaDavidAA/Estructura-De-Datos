package estDat.estDatLin;


/**
 * Write a description of class NodoDE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoDE<T>{
    private NodoDE<T> ant;
    private T         dato;
    private NodoDE<T> suc;
    public NodoDE(){
        ant = null;
        dato = null;
        suc = null;
    }
    public NodoDE(T dato){
        ant = null;
        this.dato = dato;
        suc = null;
    }
    public void setAnt(NodoDE<T> ant){
        this.ant = ant;
    }
    
    public void setDato(T dato){
        this.dato = dato;
    }
    
    public void setSuc(NodoDE<T> suc){
        this.suc = suc;
    }
    
    public NodoDE<T> getSuc(){
        return suc;
    }
    
    public T getDato(){
        return dato;
    }
    
    public NodoDE<T> getAnt(){
        return ant;
    }
}
