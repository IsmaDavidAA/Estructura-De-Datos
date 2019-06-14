package estDat.estDatLin;


public class BiCola<T> extends Cola<T>
{
    public BiCola(){
        super();
    }
    
    public BiCola(BiCola<T> nueva){
        ini = nueva.getIni();
        fin = nueva.getFin();
    }
    
    public void encolarIni(T dato){
        NodoDE<T> p = new NodoDE<T>(dato);
        if(vacia()) ini = fin = p;
        else{
            ini.setAnt(p);
            p.setSuc(ini);
            ini = p;
        }
    }
    
    public T decolarFin(){
        T elDato;
        if(vacia()) elDato = null;
        else{
            elDato = fin.getDato();
            fin = fin.getAnt();
            if(fin == null)  fin = ini =null;
            else    fin.setSuc(null);
        }
        return elDato;
    }
    
    public T verIni(){
        T elDato;
        if(vacia()) elDato = null;
        else    elDato = ini.getDato();
        return elDato;
    }
    
    public T verFin(){
        T elDato;
        if(vacia()) elDato = null;
        else    elDato = fin.getDato();
        return elDato;
    }
}