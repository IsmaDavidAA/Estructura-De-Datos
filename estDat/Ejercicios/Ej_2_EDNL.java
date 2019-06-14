
/**
 * Write a description of class Ej_2_ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ej_2_EDNL
{
    ArbolBin<Integer> prueba;
    public Ej_2_EDNL(){
        prueba = new ArbolBin<Integer>();
        llenarArbol();
    }
    
    private void llenarArbol(){
        prueba.insertarPorAmplitud(5);
        prueba.insertarPorAmplitud(4);
        prueba.insertarPorAmplitud(8);
        prueba.insertarPorAmplitud(11);
    }
    
    public String recogerIntercalado(){
        String res = "";
        BiCola<Integer> recogida = inOrden(new BiCola<Integer>(), prueba);
        while(!recogida.vacia()){
            res = res + recogida.decolar();
            if(!recogida.vacia())   res = res + recogida.decolarFin();
        }
        return res;
    }
    
    private BiCola<Integer> inOrden(BiCola<Integer> nuevo,ArbolBin<Integer> arb){
        if(!arb.vacia()){
            inOrden(nuevo, arb.getIzq());
            nuevo.encolar(arb.getRaiz());
            inOrden(nuevo, arb.getDer());
        }
        return nuevo;
    }
}
