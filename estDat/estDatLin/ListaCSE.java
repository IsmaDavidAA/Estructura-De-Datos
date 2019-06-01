package estDat.estDatLin;


/**
 * Write a description of class ListaCSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCSE<T> implements Lista<T>{   
    private NodoSE<T> ini;
 
    public boolean vacia(){
        return ini == null;
    }    
    
    public void insertar(T dato){
        NodoSE<T> aux;
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        if(vacia()){
            ini = nuevo;
            ini.setSuc(ini);
        }else{
            aux = ini;
            while(aux.getSuc() != ini){
                aux = aux.getSuc();
            }
            nuevo.setSuc(ini);
            aux.setSuc(nuevo);
        }
    }
    
    public void insertar(T dato, int pos){
        NodoSE<T> aux;
        NodoSE<T> nuevo = new NodoSE<T>(dato); 
        if(!vacia()){
            aux = ini;
            if(pos != 0){
                while(pos != 1){
                    aux = aux.getSuc();
                    pos--;
                }               
            }else{
                while(aux.getSuc() != ini)  aux = aux.getSuc();
            }
            nuevo.setSuc(aux.getSuc());  
            if(aux.getSuc() == ini) ini = nuevo;    
            aux.setSuc(nuevo);
        }else{
            if(pos == 0)    insertar(dato);
        }
    }
  
    public void insertarIni(T dato){
        NodoSE<T> aux;
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        if(vacia()){
            ini = nuevo;
            ini.setSuc(ini);
        }else{
            aux = ini;
            while(aux.getSuc() != ini){
                aux = aux.getSuc();
            }
            aux.setSuc(nuevo);
            nuevo.setSuc(ini);
            ini = nuevo;
        }
    }
    
    public T eliminar(int pos){
        T dato = null;
        NodoSE<T> aux,auxSuc;
        if(!vacia()){
            aux = ini;
            if(pos != 0){
                while(pos != 1){
                    aux = aux.getSuc();
                    pos--;
                }               
            }else{
                while(aux.getSuc() != ini)  aux = aux.getSuc();
            }
            auxSuc = aux.getSuc();
            dato = auxSuc.getDato();
            if(longitud() == 1) ini = null;
            else{
                auxSuc = auxSuc.getSuc();
                if(aux.getSuc() == ini) ini = auxSuc;    
                aux.setSuc(ini);
            }
        }
        return dato;
    }
    
    public T eliminar(T dato){
        T datito = null; 
        NodoSE<T> aux,auxSuc;
        int pos = longitud();
        if(!vacia()){
            aux = ini;
            if(!dato.equals(aux.getDato())){
                while(!dato.equals(aux.getSuc().getDato()) && pos!=0){
                    aux = aux.getSuc();
                    pos--;
                }
            }else{
                while(aux.getSuc() != ini)  aux = aux.getSuc();
            }
            if(longitud() == 1 && dato.equals(ini.getDato())){
                ini = null;
                datito = dato;
            }else if(dato.equals(aux.getSuc().getDato())){
                auxSuc = aux.getSuc();
                datito = auxSuc.getDato();
                auxSuc = auxSuc.getSuc();
                if(aux.getSuc() == ini) ini = aux;    
                aux.setSuc(auxSuc);
            }
        }
        return datito;
    }
    
    public void eliminar(int desde, int hasta){
    }
    
    public void eliminarTodas(T dato){
        NodoSE<T> aux,auxSuc;
        if(!vacia()){
            aux = ini;
            auxSuc = aux.getSuc();
            int longitud = longitud();
            if(longitud == 1){ if(dato.equals(aux.getDato())) ini = null;
            }else{
                for(int i = 0; i<= longitud; i++){
                    if(dato.equals(aux.getDato()))eliminar(dato);
                    else    aux = aux.getSuc();
                }
            }
        }
    }
    
    public T acceder(int pos){
        NodoSE<T> aux;
        T elemento;
        if(vacia()) elemento = null;
        else{
            aux = ini;
            while(pos != 0){
                aux = aux.getSuc();
                pos--;
            }
            elemento = aux.getDato();
        }
        return elemento;
    }
    
    public T acceder(T dato){
        NodoSE<T> aux;
        T elemento = null;
        if(!vacia()){
            aux = ini;
            do{
                if(dato.equals(aux.getDato())) elemento = aux.getDato(); 
                aux = aux.getSuc();
            }while(aux != ini && elemento == null);
        }
        return elemento;
    }
    
    public Lista<T> acceder(int desde, int hasta){
        return null;
    }
    
    public int longitud(){
        NodoSE<T> aux;
        int pos;
        if(vacia()) pos = -1;
        else{
            aux = ini;
            pos = 1;
            while(aux.getSuc() != ini){
                aux = aux.getSuc();
                pos ++;
            }
        }
        return pos;
    }
    
    public boolean buscar(T dato){
        NodoSE<T> aux;
        boolean encontrado = false;
        if(!vacia()){
            aux = ini;
            do{
                if(dato.equals(aux.getDato())) encontrado = true; 
                aux = aux.getSuc();
            }while(aux != ini && encontrado == false);
        }
        return encontrado;
    }
    
    public int indiceDe(T dato){
        int pos = -1;
        NodoSE<T> aux;
        boolean encontrado = false;
        if(!vacia() && buscar(dato)){
            aux = ini;
            do{
                if(dato.equals(aux.getDato())) encontrado = true; 
                aux = aux.getSuc();
                pos++;
            }while(aux != ini && encontrado == false);
        }
        return pos;
    }
    
}
