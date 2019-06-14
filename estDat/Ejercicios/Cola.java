package estDat.Ejercicios;

public class Cola<T>
{
    protected NodoDE<T> ini, fin;
    public Cola()
    {
        ini = fin = null;
    }

    public NodoDE<T> getIni(){
        return ini;
    }
    
    public NodoDE<T> getFin(){
        return fin;
    }
    
    public boolean vacia(){
        return fin == null && ini == null;
    }
    public void encolar(T dato){
        NodoDE<T> p = new NodoDE <T> (dato);
        if (vacia()){
            ini = fin = p;
        }else{
            fin.setSuc(p);
            p.setAnt(fin);
            fin = p;
        }
    }
    public T decolar(){
        T elDato;
        if(vacia()){
            elDato= null;
        }else{
            elDato = ini.getDato();
            ini = ini.getSuc();
            if(ini == null)
                fin = null;
            else{
                ini.setAnt(null);
            }
        }
        return elDato;
    }
    public T ver(){
        T elDato;
        if(vacia()) elDato = null;
        else
            elDato = ini.getDato();
            return elDato;
    }
}
