package estDat.estDatLin;
    
    
    /**
     * Write a description of class ListaDE here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
public class ListaDE<T> implements Lista<T>{
    
    private NodoDE<T> ini;
    public ListaDE(){
        this.ini = null;
    }
    public boolean vacia(){
        return ini == null;
    }
            
    public void insertar(T dato){
        NodoDE<T> aux;
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(vacia()){            
            ini = nuevo;
        }else{
            aux = ini;
            while(aux.getSuc() != null){
                aux = aux.getSuc();
            }
            aux.setSuc(nuevo);
            nuevo.setAnt(aux);
        }
    }
        
    public void insertar(T dato, int pos){
        NodoDE<T> aux, auxSuc;
        NodoDE<T> nuevo = new NodoDE<T>(dato);
            
        if(pos == 0){
            if(!vacia()){
                ini.setAnt(nuevo);
                nuevo.setSuc(ini);    
            }
            ini = nuevo;
        }else{
            if(!vacia()){
                aux = ini;
                while(aux.getSuc() != null && pos > 1 ){
                    aux = aux.getSuc();
                    pos --;
                }
                if(aux.getSuc() == null){
                    if(pos == 1){
                        aux.setSuc(nuevo);
                        nuevo.setAnt(aux);
                    }
                }else{
                    auxSuc = aux.getSuc();
                    aux.setSuc(nuevo);
                    nuevo.setAnt(aux);
                    auxSuc.setAnt(nuevo);
                    nuevo.setSuc(auxSuc);
                }   
            }
        }   
    }
        
    public void insertarIni(T dato){
        NodoDE<T> aux;
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(!vacia()){            
            aux = ini;
            aux.setAnt(nuevo);
            nuevo.setSuc(aux);   
        }
        ini = nuevo;
    }
    public T eliminar(int pos){
        T eliminado = null;
        NodoDE<T> auxAnt,aux,auxSuc;     
        if(pos == 0){
            if(!vacia()){
                eliminado = ini.getDato();
                ini = ini.getSuc();  
            }
        }else{
            if(!vacia()){
                aux = ini;
                while(aux.getSuc() != null && pos != 0 ){
                    aux = aux.getSuc();
                    pos --;
                }
                auxAnt = aux.getAnt();
                if(pos == 0){
                    eliminado = aux.getDato();
                    if(aux.getSuc() == null){
                        aux.setAnt(null);
                        auxAnt.setSuc(null);
                    }else{
                        auxSuc = aux.getSuc();
                        auxAnt.setSuc(auxSuc);
                        auxSuc.setAnt(auxAnt);
                    }   
                }
            }
        }
        return eliminado;
    }
    public T eliminar(T dato){
        NodoDE<T> aux,auxAnt,auxSuc;
        T eliminado = null;
        if(!vacia()){      
            if(ini.getDato().equals(dato)){
                eliminado = ini.getDato();
                ini = ini.getSuc();
            }else{
                aux = ini;
                boolean encontrado = false;
                while(aux.getSuc() != null && !encontrado){
                    aux = aux.getSuc();
                    if(aux.getDato().equals(dato))  encontrado = true;
                }            
                if(encontrado){
                    auxAnt = aux.getAnt();
                    eliminado = aux.getDato();
                    if(aux.getSuc() == null){
                        aux.setAnt(null);
                        auxAnt.setSuc(null);
                    }else{
                        auxSuc = aux.getSuc();
                        auxAnt.setSuc(auxSuc);
                        auxSuc.setAnt(auxAnt);
                    } 
                }
            }
        }
        return eliminado;
    }
    public void eliminar(int desde, int hasta){
        NodoDE<T> aux,auxAnt,auxSuc;
        if(!vacia()){       
            aux = ini;
            int pos = longitud();
            while(0 <= pos && desde >= 0 && hasta >= 0 && aux != null){
                if(desde == 0 && hasta >= 0){
                    auxAnt = aux.getAnt();
                    if(aux.getSuc() == null){
                        aux.setAnt(null);
                        auxAnt.setSuc(null);
                    }else{
                        auxSuc = aux.getSuc();
                        auxAnt.setSuc(auxSuc);
                        auxSuc.setAnt(auxAnt);
                    }
                    aux = auxAnt.getSuc();
                }else{
                    aux = aux.getSuc();
                    desde --;
                }
                hasta --;
                pos --;
            }     
        }
    }
    public void eliminarTodas(T dato){
        NodoDE<T> aux,auxAnt,auxSuc;
        if(!vacia()){      
            aux = ini;
            boolean encontrado = false;      
            do{
                if(aux.getDato().equals(dato))  encontrado = true;
                if(encontrado){
                    auxAnt = aux.getAnt();
                    if(aux.getSuc() == null){
                        aux.setAnt(null);
                        auxAnt.setSuc(null);
                    }else{
                        auxSuc = aux.getSuc();
                        auxAnt.setSuc(auxSuc);
                        auxSuc.setAnt(auxAnt);
                    }
                    encontrado = false;
                    aux = auxAnt.getSuc();
                }else   aux = aux.getSuc();
            }while(aux.getSuc() != null);         
        }
    }
    public T acceder(int pos){
        NodoDE<T> aux;
        T dato = null;
        if(!vacia()){                        
            aux = ini;
            while(aux.getSuc() != null && pos != 0){
                aux = aux.getSuc();
                pos = pos -1;
            }   
            if(pos == 0) dato = aux.getDato();
        }
        return dato;
    }
    public T acceder(T dato){
        NodoDE<T> aux;
        T datito = null;
        if(!vacia()){                        
            aux = ini;
            int pos = 0;
            boolean encontrado = false;
            while(pos < longitud() && !encontrado) {
                if(dato.equals(aux.getDato())){
                    datito = aux.getDato();
                    encontrado = true;
                }
                aux = aux.getSuc();
                pos ++;
            }  
        }
        return datito;
    }
    public Lista<T> acceder(int desde, int hasta){
        NodoDE<T> aux;
        ListaDE<T> nuevaLista = null; 
        if(!vacia()){  
            aux = ini;
            int pos = longitud();
            if(desde < pos){
                nuevaLista = new ListaDE<T>();  
                while(0 <= pos && desde >= 0 && hasta >= 0 && aux != null){
                    if(desde == 0 && hasta >= 0)    nuevaLista.insertar(aux.getDato());
                    else  desde --;
                    hasta --;
                    aux = aux.getSuc();
                    pos --;
                }        
            }
        }
        return nuevaLista;
    }
    public int longitud(){
        NodoDE<T> aux;
        int longi = 0;
        if(!vacia()){
            aux = ini;
            longi = 1;
            while(aux.getSuc() != null){
                aux = aux.getSuc();
                longi ++;
            }
        }
        return longi;
    }
    public boolean buscar(T dato){
        NodoDE<T> aux;
        boolean existe = false;
        if(!vacia()){
            aux = ini;
            int pos = 0;
            while(pos < longitud()){
                if(aux.getDato().equals(dato)) existe = true;
                aux = aux.getSuc();
                pos ++;
            }
        }
        return existe;
    }
    public int indiceDe(T dato){
        NodoDE<T> aux;
        int pos = 0;
        boolean encontrado = false;
        if(!vacia()){
            aux = ini;            
            while(pos < longitud() && !encontrado){
                if(aux.getDato().equals(dato))encontrado = true;
                aux = aux.getSuc();
                pos ++;
            }
        }
        if(encontrado) pos --;
        else pos = -1;
        return pos;
    }
}
