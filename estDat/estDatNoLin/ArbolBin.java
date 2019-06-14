

public class ArbolBin<T> 
{
    private T raiz;
    private ArbolBin<T> izq, der;
    public ArbolBin() {
        raiz = null;
        izq = der = null;
    }
    public boolean vacia() {
        return raiz == null;
    }
    public boolean insertarPorProfundidad(T dato, ListaSE<T> ruta) {
        boolean inserto = false;
        T actual;
        if(vacia()) {
            if (ruta.vacia()) {
                raiz = dato;
                izq = new ArbolBin<T>();
                der = new ArbolBin<T>();
                inserto = true;
            } else {
                inserto = false;
            }
        } else {
            if (ruta.vacia()) {
                inserto = false;
            } else {
                actual = ruta.eliminar(0);
                if (actual.equals(raiz)) {
                    inserto = izq.insertarPorProfundidad(dato, ruta);
                    if (!inserto) {
                        inserto = der.insertarPorProfundidad(dato, ruta);
                    }
                } else{
                    inserto = false;
                }
                ruta.insertar(actual, 0);
            }
        }
        return inserto;
    }
    
    public void insertarPorAmplitud(T dato) {
        Cola<ArbolBin<T>> cola;
        cola = new Cola<ArbolBin<T>>();
        cola.encolar(this);
        insertarPorAmplitud(dato,cola);
    }
    
    private void insertarPorAmplitud(T dato,Cola<ArbolBin<T>> cola){
        ArbolBin<T> arb;
        arb = cola.decolar();
        if(arb.vacia()){
            arb.raiz = dato;
            arb.izq = new ArbolBin<T>();
            arb.der = new ArbolBin<T>();
        }else{
            cola.encolar(arb.izq);
            cola.encolar(arb.der);
            insertarPorAmplitud(dato,cola);
        }
    }
    
    public ListaSE<T> recolectarHojas() {
        ListaSE<T> lista = new ListaSE<T>();
        
        recolectarHojas(lista);
        return lista;
    }
    private void recolectarHojas(ListaSE<T> lista) {
        if (!vacia()) {
            if (izq.vacia() && der.vacia()) {
                lista.insertar(raiz);
            } else {
                izq.recolectarHojas(lista);
                der.recolectarHojas(lista);
            }
        }
        
    }
    public String toString() {
        String res = "";
        if (!vacia()) {
            res = raiz.toString() + "-" + izq.toString() + "-" + der.toString();
        }
        return res;
    }
    
    public String toStringX() {
        String res = "";
        if (!vacia()) {
            String e1 = "x";
            String e2 = izq.toStringX();
            String e3 = der.toStringX();
            res = e1 + "-" + e2 + "-" + e3;
        }
        return res;
    
    }
    
    
    
    public boolean igualdadDeBordes(ArbolBin<T> otro) {
        ListaSE<T> hojas1 = recolectarHojas();
        ListaSE<T> hojas2 = otro.recolectarHojas();
        boolean iguales = true;
        int i = 0;
        if (hojas1.longitud() != hojas2.longitud()) {
            iguales = false;
        } else {
            while(i < hojas1.longitud() && iguales) {
                T dato1 = hojas1.acceder(i);
                T dato2 = hojas2.acceder(i);
                if (!dato1.equals(dato2)) {
                    iguales = false;
                }
                i++;
            }
        }
        return iguales;
    }
    
    public void eliminar(T dato){
        if(!vacia()){
            if(raiz.equals(dato)){
                raiz = null;
                izq = der = null;
            }else{
                izq.eliminar(dato);
                der.eliminar(dato);
            }
        }
    }
    
    public boolean esHoja(){
        return der.vacia() && izq.vacia();
    }
    
    public ListaSE<BiCola<T>> RecogerRamasDelArbol(){
        return RecogerRamasDelArbol(new BiCola<T>(),new ListaSE<BiCola<T>>());
    }
    
    private ListaSE<BiCola<T>> RecogerRamasDelArbol(BiCola<T> rama,ListaSE<BiCola<T>> listaRamas){    
        if(raiz != null){
            rama.encolar(raiz);
            if(esHoja()){
                BiCola<T> nuevaRama = new BiCola(rama);
                listaRamas.insertar(nuevaRama);
                rama.decolarFin();
            }else{
                izq.RecogerRamasDelArbol(rama,listaRamas);
                der.RecogerRamasDelArbol(rama,listaRamas);
                rama.decolarFin();
            } 
        }
        return listaRamas;
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
    
    
    public Pila<T> inOrden(){
        return inOrden(new Pila<T>(), this);
    }
    
    private Pila<T> inOrden(Pila<T> nuevo,ArbolBin<T> arb){
        if(!arb.vacia()){
            inOrden(nuevo, arb.izq);
            nuevo.push(arb.raiz);
            inOrden(nuevo, arb.der);
        }
        return nuevo;
    }
    
    public T getRaiz(){
        return raiz;
    }
    
    public ArbolBin<T> getDer(){
        return der;
    }
    
    public ArbolBin<T> getIzq(){
        return izq;
    }
    
    public void setIzq(ArbolBin<T> izq){
        this.izq = izq;
    }

    public ArbolBin(T raiz, ArbolBin<T> izq, ArbolBin<T> der){
        this.raiz = raiz;
        this.izq = izq;
        this.der = der;
    }
    
       
    public ListaSE<BiCola<T>> RecogerRamasDireccion(){
        return RecogerRamasDireccion(new BiCola<T>(),new ListaSE<BiCola<T>>());
    }
    
    private ListaSE<BiCola<T>> RecogerRamasDireccion(BiCola<T> rama,ListaSE<BiCola<T>> listaRamas){    
        if(raiz != null){
            rama.encolar(raiz);
            if(esHoja()){
                BiCola<T> nuevaRama = new BiCola(rama);
                listaRamas.insertar(nuevaRama);
                rama.decolarFin();
            }else{
                izq.RecogerRamasDireccion(rama,listaRamas);
                der.RecogerRamasDireccion(rama,listaRamas);
                rama.decolarFin();
            } 
        }
        return listaRamas;
    }
}
