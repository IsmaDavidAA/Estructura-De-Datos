
/**
 * Write a description of class Ej_24_EDNL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ej_24_EDNL
{
    ArbolBB<Integer> prueba;
    public Ej_24_EDNL(){
        prueba = new ArbolBB<Integer>();
        llenarPrueba();
    }
    
    private void llenarPrueba(){
        prueba.insertar(7);
        prueba.insertar(5);
        prueba.insertar(15);
        prueba.insertar(3);
        prueba.insertar(6);
        prueba.insertar(19);
    }

    public String intercalar(){
        String res = "";
        BiCola<Integer> nueva = prueba.inOrdenBi();
        while(!nueva.vacia()){
            res = res + nueva.decolar();
            if(!nueva.vacia())  res = res + nueva.decolarFin();
        }
        return res;
    }
}
