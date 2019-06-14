package estDat.estDatLin;

public class ColaDePrioridades< T extends Comparable<T>> extends Cola
{
    public ColaDePrioridades() {
        super();
    }
    public void encolar(T dato) {
        NodoDE<T> nuevo = new NodoDE(dato);
        NodoDE<T> q;
        if (vacia()) {
            ini = nuevo;
            fin = nuevo;
        } else {
            q = buscarUbicacion(fin, dato);
            if (q == null) {
                nuevo.setSuc(ini);
                ini.setAnt(nuevo);
                ini = nuevo;
            } else if (q == fin) {
                nuevo.setAnt(fin);
                fin.setSuc(nuevo);
                fin = nuevo;
            } else {
                NodoDE<T> sig = q.getSuc();
                q.setSuc(nuevo);
                sig.setAnt(nuevo);
                nuevo.setAnt(q);
                nuevo.setSuc(sig);
            }
        }
    }
    private NodoDE<T> buscarUbicacion(NodoDE<T> actual, T dato) {
        NodoDE<T> res;
        if (actual == null) { 
            res = null;//sucede cuando el dato es mas chico que todos los valores de la cola
        } else {
            T datoActual = actual.getDato();
            if (dato.compareTo(datoActual) < 0) {
                res = buscarUbicacion(actual.getAnt(), dato);
            } else {
                res = actual;
            }
        }
        return res;
    }
}



