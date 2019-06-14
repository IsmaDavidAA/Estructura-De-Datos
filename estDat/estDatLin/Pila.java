public class Pila<T>
{
    private T tope;
    private Pila<T> base;
    public Pila(){
        tope = null;
        base = null;
    }
    
    public Pila(Pila<T> otra){
        tope = otra.getTope();
        base = otra.getBase();
    }
    
    public void setPila(Pila<T> otra){
        tope = otra.getTope();
        base = otra.getBase();
    }
    
    public boolean vacia(){
        return tope == null;
    }
    
    public void push(T dato){
        if(vacia()){
            tope = dato;
            base = new Pila<T>();
        }else{
            base = new Pila<T>(this);
            tope = dato;
        }
    }
    
    public T pop(){
        T elDato;
        if(vacia()) elDato = null;
        else{
            elDato = tope;
            tope = base.getTope();
            base = base.getBase();
        }
        return elDato;
    }
    
    public T top(){
        return tope;
    }
    
    private T getTope(){
        return tope;
    }
    
    private Pila<T> getBase(){
        return base;
    }
}