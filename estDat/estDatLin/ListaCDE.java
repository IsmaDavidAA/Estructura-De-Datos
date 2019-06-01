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
        NodoDE<T> aux;
        NodoDE<T> nuevo = new NodoDE<T>(dato); 
        if(!vacia()){
            aux = ini;
            if(pos != 0){
                while(pos != 1){
                    aux = aux.getSuc();
                    pos--;
                }               
            }else{
                aux = aux.getAnt();
            }
            nuevo.setSuc(aux.getSuc());
            nuevo.setAnt(aux);
            if(aux.getSuc() == ini) ini = nuevo;    
            aux.setSuc(nuevo);
        }else{
            if(pos == 0)    insertar(dato);
        }
    }
    public void insertarIni(T dato){
        NodoDE<T> aux;
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(vacia()){
            ini = nuevo;
            ini.setSuc(ini);
            ini.setAnt(ini);
        }else{
            aux = ini;
            aux = aux.getAnt();
            aux.setSuc(nuevo);
            nuevo.setSuc(ini);
            nuevo.setAnt(aux);
            ini = nuevo;
        }
    }
    public T eliminar(int pos){
        T dato = null;
        NodoDE<T> aux,auxSuc;
        if(!vacia()){
            aux = ini;
            if(pos != 0){
                while(pos != 1){
                    aux = aux.getSuc();
                    pos--;
                }               
            }else{
                aux = aux.getAnt();
            }
            auxSuc = aux.getSuc();
            dato = auxSuc.getDato();
            if(longitud() == 1) ini = null;
            else{
                auxSuc = auxSuc.getSuc();
                auxSuc.setAnt(aux);
                if(aux.getSuc() == ini) ini = auxSuc;    
                aux.setSuc(auxSuc);
            }
        }
        return dato;
    }
    public T eliminar(T dato){
        T datito = null; 
        NodoDE<T> aux,auxSuc;
        int pos = longitud();
        if(!vacia()){
            aux = ini;
            if(!dato.equals(aux.getDato())){
                while(!dato.equals(aux.getSuc().getDato()) && pos!=0){
                    aux = aux.getSuc();
                    pos--;
                }
            }else{
                aux = aux.getAnt();
            }
            if(longitud() == 1 && dato.equals(ini.getDato())){
                ini = null;
                datito = dato;
            }else if(dato.equals(aux.getSuc().getDato())){
                auxSuc = aux.getSuc();
                datito = auxSuc.getDato();
                auxSuc = auxSuc.getSuc();
                auxSuc.setAnt(aux);
                if(aux.getSuc() == ini) ini = auxSuc;    
                aux.setSuc(auxSuc);
            }
        }
        return datito;
    }
    public void eliminar(int desde, int hasta){
    }
    public void eliminarTodas(T dato){
        NodoDE<T> aux,auxSuc;
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
        NodoDE<T> aux;
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
        NodoDE<T> aux;
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
        NodoDE<T> aux;
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
        NodoDE<T> aux;
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
        NodoDE<T> aux;
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
