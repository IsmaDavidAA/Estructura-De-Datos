
import java.util.ArrayList;

public class ArbolBB<T extends Comparable<T>>
{
    private T raiz;
    private ArbolBB<T> izq, der;
    public ArbolBB() {
        raiz = null;
        izq = der = null;
    }
    public boolean vacia() {
        return raiz == null;
    }
    public void insertar(T dato) {
        if (vacia()) {
            raiz = dato;
            izq = new ArbolBB();
            der = new ArbolBB();
        } else {
            if (dato.compareTo(raiz) < 0) {
                izq.insertar(dato);
            } else {
                der.insertar(dato);
            }
        }
    }
    
    
    public T eliminar(T d) {
        T dato;
        ArbolBB<T> arbol, q;
        int caso;
        if (vacia()) {
            dato = null;
        } else {
            if (raiz.compareTo(d) == 0) {
                dato = raiz;
                caso = verificarCaso();
                switch(caso) {
                    case 0: raiz = null;
                            izq = null;
                            der = null;
                            break;
                    case 1: raiz = izq.raiz;
                            izq = izq.izq;
                            der = izq.der;
                            break;
                    case 2: raiz = der.raiz;
                            izq = der.izq;
                            der = der.der;
                            break;
                    case 3: q = der.masIzquierda();
                            raiz = q.raiz;
                            q.raiz = q.der.raiz;
                            q.der = q.der.der;
                            q.izq = q.der.izq;
                            break;
                }
            } else if (d.compareTo(raiz) < 0) {
                dato = izq.eliminar(d);
            } else {
                dato = der.eliminar(d);
            }
        }
        return dato;
    }
    private ArbolBB<T> masIzquierda() {
        ArbolBB<T> res;
        if (izq.vacia()) {
            res = this;
        } else {
            res = izq.masIzquierda();
        }
        return res;
    }
    private int verificarCaso() {
        int caso = 3;
        if (izq.vacia() && der.vacia()) caso = 0;
        else if (!izq.vacia() && der.vacia())   caso = 1;
        else if (izq.vacia() && !der.vacia())   caso = 2;
        return caso;
    }
    
    public ArrayList[] elementosPorNiveles() {
        int niveles = contarNiveles();
        ArrayList[] elementosNivel = new ArrayList[niveles];
        for (int i = 0; i<niveles; i++) {
            elementosNivel[i] = new ArrayList();
        }
        elementosPorNiveles(elementosNivel, 0);
        return elementosNivel;
    }
    private void elementosPorNiveles(ArrayList[] elementosNivel, int nivel) {
        if(!vacia()) {
            ArrayList<T> listaNivel = elementosNivel[nivel];
            listaNivel.add(raiz);
            izq.elementosPorNiveles(elementosNivel, nivel+1);
            der.elementosPorNiveles(elementosNivel, nivel+1);
        }
    }
    public int contarNiveles() {
        int niveles;
        if (vacia()) {
            niveles = 0;
        } else {
            int nivelesIzq = izq.contarNiveles();
            int nivelesDer = der.contarNiveles();
            niveles = Math.max(nivelesIzq, nivelesDer) + 1;
        }
        return niveles;
    }
    public ArrayList<ArrayList<T>> listarHojas() {
        ArrayList<ArrayList<T>> listaHojas = new ArrayList();
        ArrayList<T> hojas;
        while(!vacia()) {
            hojas = new ArrayList<T>();
            listarHojas(hojas);
            listaHojas.add(hojas);
        }
        return listaHojas;
    }
    private void listarHojas(ArrayList<T> hojas) {
        if (!vacia()) {
            if (izq.vacia() && der.vacia()) {
                hojas.add(raiz);
                izq = null;
                der = null;
                raiz = null;
            } else {
                izq.listarHojas(hojas);
                der.listarHojas(hojas);
            }
        }
        
    }
    
    private boolean contains( T x, ArbolBB<T> t ){
        boolean res;
        if( t == null ) res =  false;
        int compareResult = x.compareTo( t.raiz);
        if( compareResult < 0 ) res = contains( x, t.izq);
            else if( compareResult > 0 )    res = contains( x, t.der);
            else res = true;
        // Match
        return res;
    }
    
    private ArbolBB<T> eliminar(T x, ArbolBB<T> t ){
        ArbolBB<T> arbol; 
        if( t == null ) arbol = t;
        // Item not found; do nothing
        int compareResult = x.compareTo( t.raiz);
        if( compareResult < 0 ) t.izq = eliminar( x, t.izq);
        else if( compareResult > 0 )    t.der = eliminar( x, t.der);
        else if( t.izq != null && t.der != null ) // Two children
        {
            t.raiz = buscarMenor( t.der).raiz;
            t.der = eliminar( t.raiz , t.der);
        }
        else
        t = ( t.izq != null ) ? t.izq : t.der;
        return t;
    }
    
    private ArbolBB<T> buscarMenor(ArbolBB<T> t ){
        ArbolBB<T> arbol;
        if(t == null) arbol = null;
        else if(t.izq == null) arbol = t;
        return buscarMenor(t.izq);
    }
    
    public Pila<T> inOrden(){
        return inOrden(new Pila<T>(), this);
    }
    
    private Pila<T> inOrden(Pila<T> nuevo,ArbolBB<T> aBB){
        if(!aBB.vacia()){
            inOrden(nuevo, aBB.izq);
            nuevo.push(aBB.raiz);
            inOrden(nuevo, aBB.der);
        }
        return nuevo;
    }
    
    public BiCola<T> inOrdenBi(){
        return inOrden(new BiCola<T>(), this);
    }
    
    private BiCola<T> inOrden(BiCola<T> nuevo,ArbolBB<T> aBB){
        if(!aBB.vacia()){
            inOrden(nuevo, aBB.izq);
            nuevo.encolar(aBB.raiz);
            inOrden(nuevo, aBB.der);
        }
        return nuevo;
    }
    
    public ListaSE<BiCola<T>> RecogerRamasDelArbolenBiCola(){
        ListaSE<Pila<T>> lista = RecogerRamasDelArbol(new Pila<T>(),new ListaSE<Pila<T>>());
        ListaSE<BiCola<T>> res = new ListaSE<BiCola<T>>();
        while(!lista.vacia()){
            Pila<T> p = lista.eliminar(0);
            BiCola<T> n = new BiCola<T>();
            while(!p.vacia())   n.encolar(p.pop());
            res.insertar(n);
        }
        return res;
    }
    
    public ListaSE<Pila<T>> RecogerRamasDelArbol(){
        return RecogerRamasDelArbol(new Pila<T>(),new ListaSE<Pila<T>>());
    }
    
    private ListaSE<Pila<T>> RecogerRamasDelArbol(Pila<T> rama,ListaSE<Pila<T>> listaRamas){    
        if(raiz != null){
            rama.push(raiz);
            if(esHoja()){
                Pila<T> nuevaRama = new Pila(rama);
                listaRamas.insertar(nuevaRama);
                rama.pop();
            }else{
                izq.RecogerRamasDelArbol(rama,listaRamas);
                der.RecogerRamasDelArbol(rama,listaRamas);
                rama.pop();
            } 
        }
        return listaRamas;
    }
    
    public boolean esHoja(){
        return der.vacia() && izq.vacia();
    }
    
    public BiCola<T> recogerEnBiCola(T dato){
        Pila<T> n = new Pila<T>(recogerRama(dato));
        BiCola<T> res = new BiCola<T>();
        while(!n.vacia()) res.encolarIni(n.pop());
        return res;
    }
    
    public Pila<T> recogerRama(T dato){
        return recogerRama(new Pila<T>(),dato,new Pila<T>());
    }
    
    private Pila<T> recogerRama(Pila<T> rama,T dato,Pila<T> camino){
        if(raiz != null){
            rama.push(raiz);
            if(dato.equals(raiz)){
                camino.setPila(rama);
                rama.pop();
            }else{
                izq.recogerRama(rama,dato,camino);
                der.recogerRama(rama,dato,camino);
                rama.pop();
            } 
        }
        return camino;
    }
    
    
    public T getRaiz(){
        return raiz;
    }
    
    public ArbolBB<T> getDer(){
        return der;
    }
    
    public ArbolBB<T> getIzq(){
        return izq;
    }
    
    /*
    public Lista<T> ramaMasChica() {
        Lista<T> ramaChica;
        if (vacia()) {
            ramaChica = new ListaSE();
        } else {
            Lista<T> ramaChicaIzq = izq.ramaMasChica();
            Lista<T> ramaChicaDer = der.ramaMasChica();
            if (ramaChicaIzq.longitud() < ramaChicaDer.longitud()) {
                ramaChica = ramaChicaIzq;
            } else {
                ramaChica = ramaChicaDer;
            }
            ramaChica.insertar(raiz, 0);
        }
        return ramaChica;
    }
    
    public void darVueltaRamaChica() {
        Lista<T> rama = ramaMasChica();
        Pila<T> pila = new Pila();
        for (int i = 0; i<rama.longitud(); i++) {
            pila.apilar(rama.acceder(i));
        }
        darVuelta(rama, pila, 0);
    }
    private void darVuelta(Lista<T> camino, Pila<T> pila, int pos) {
        if (!vacia() && pos < camino.longitud()) {
            T datoLista = camino.acceder(pos);
            if (datoLista.equals(raiz)) {
                T dato = pila.desapilar();
                raiz = dato;
                izq.darVuelta(camino, pila, pos+1);
                der.darVuelta(camino, pila, pos+1);
            }
        }
    }
    public void espejo() {
        if (!vacia()) {
            ArbolBB<T> aux;
            aux = izq;
            izq = der;
            der = aux;
            izq.espejo();
            der.espejo();
        }
    }
    */
}

