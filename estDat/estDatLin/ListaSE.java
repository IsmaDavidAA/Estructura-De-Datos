
public class ListaSE<T>{
    private T          ini;
    private ListaSE<T> sig;
    public ListaSE(){
        ini = null;
        sig = null;
    }
    
    public boolean vacia(){
        return ini == null;
    }
    public void insertar(T dato){
        if(vacia()){
            ini = dato;
            sig = new ListaSE<T>(); 
        }else{
            sig.insertar(dato);
        }
    }
    public void insertar(T dato, int pos){
        if(pos<= longitud()){        
            if(pos==0){
                insertarIni(dato);                
            }else{
                sig.insertar(dato, pos-1); 
            }
        }
    }
    public void insertarIni(T dato){
        if(vacia()){
            ini = dato;
            sig = new ListaSE<T>();
        }else{
            T aux = ini;
            ini = dato;
            sig.insertarIni(aux);
        }
    }
    public T eliminar(int pos){
        T eliminado;
        if(!vacia()){
            if(pos == 0){ 
                eliminado = ini;
                ini = sig.getIni();
                sig = sig.getSig();
            }else{
                eliminado = sig.eliminar(pos-1);
            }
        }else{
            eliminado = null;
        }
        return eliminado; 
    }
    public T eliminar(T dato){
        T eliminado;
        if(!vacia()){
            if(ini.equals(dato)){ 
                eliminado = ini;
                ini = sig.getIni();
                sig = sig.getSig();
            }else{
                eliminado = sig.eliminar(dato);
            }
        }else{
            eliminado = null;
        }
        return eliminado; 
    }
    public void eliminar(int desde, int hasta){
        if(!vacia() && desde >= 0){
            if(desde == 0){ 
                ini = sig.getIni();
                sig = sig.getSig(); 
                if(hasta > 0 && sig != null){
                    eliminar(desde,hasta-1); 
                }    
            }else{
                sig.eliminar(desde-1,hasta-1);
            }
        } 
    }
    
    public ListaSE<T> acceder(int desde, int hasta){
        ListaSE<T> res;
        int longi = longitud();
        if(desde <= longi && hasta <= longi){
            res = new ListaSE();
            if(desde <= hasta){
                res.insertar(acceder(desde));
                res.sig = acceder(desde +1, hasta);
            }
        } else res = null;
        return res;
    } 
    
    public void eliminarTodas(T dato){
        if(!vacia()){
            if(dato.equals(ini)){
                ini = sig.getIni();
                sig = sig.getSig();
                eliminarTodas(dato);
            }else{
                sig.eliminarTodas(dato);
            }
        }
    }
    
    public T acceder(int pos){
        T dato;
        if(vacia()){
            dato = null;
        }else{
            if(pos == 0){
                dato = ini;
            }else{
                dato = sig.acceder(pos-1);
            }            
        }
        return dato;
    }
    public T acceder(T dato){
        T q;
        if(vacia()){
            q = null;
        }else{
            if(dato.equals(ini)){
                q = ini;
            }else{
                q = sig.acceder(dato);
            }
        }
        return q;
    }
    
    public int longitud(){
        int length = 0;
        if(!vacia())  length = 1 + sig.longitud();
        return length;
    }
    public boolean buscar(T dato){
        boolean existe = false;
        if(!vacia()){
            if(dato.equals(ini)){
                existe = true;
            }else{
                existe = sig.buscar(dato);
            }
        }
        return existe;
    }
    public int indiceDe(T dato){
        int pos;
        if(!buscar(dato)){
            pos = -1;
        }else{
            if(dato.equals(ini)){
                pos = 0;
            }else{
                pos = 1 + sig.indiceDe(dato);
            }
        }
        return pos;
    }
    public T getIni(){
        return ini;
    }
    public ListaSE<T> getSig(){
        return sig;
    }  
    public void setIni(T ini){
        this.ini = ini;
    }
    public void setSig(ListaSE<T> sig){
        this.sig = sig;
    }  
}
