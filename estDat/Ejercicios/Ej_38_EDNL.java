
/**
 * Write a description of class Ej_38_EDNL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ej_38_EDNL
{
    ArbolBin<Integer> prueba;
    ArbolBin<Integer> prueba2;
    public Ej_38_EDNL(){
        prueba = new ArbolBin<Integer>();
        prueba2 = new ArbolBin<Integer>();
        llenarArbol();
    }
    
    private void llenarArbol(){
        prueba.insertarPorAmplitud(12);
        prueba.insertarPorAmplitud(1);
        prueba.insertarPorAmplitud(2);
        prueba.insertarPorAmplitud(8);
        
        prueba2.insertarPorAmplitud(9);
        prueba2.insertarPorAmplitud(6);
        prueba2.insertarPorAmplitud(2);
        prueba2.insertarPorAmplitud(7);
    }
    
    public boolean sonSempeso(int n){
        Pila<Integer> arb1 = preOrden(prueba);
        Pila<Integer> arb2 = preOrden(prueba2);
        boolean sempeso = true;
        if(fusionablesP()){
            while(!arb1.vacia()){
                if(!arb2.vacia()){
                    if(diferencia(arb1.pop(),arb2.pop(),n));
                    else    sempeso = false;
                }
            }
        }else   sempeso = false;
        return sempeso;
    }
    
    private boolean diferencia(int x, int y,int n){
        boolean res;
        if(Math.abs(x-y) <= n)  res = true;
        else    res = false;
        return res;
    }
    
    public Pila<Integer> preOrden(ArbolBin<Integer> arb){
        Pila<Integer> p = new Pila<Integer>();
        listaPila(p, arb);
        return p;
    }
    
    public void listaPila(Pila<Integer> p,ArbolBin<Integer> arb){
        int x = -1;
        if (!arb.vacia()) {
            p.push(arb.getRaiz());
            p.push(x);
            listaPila(p,arb.getIzq());
            p.push(x);
            listaPila(p,arb.getDer());
        }
    }
    
    public boolean fusionablesP(){
        Pila<Integer> arb1 = preOrden(prueba);
        Pila<Integer> arb2 = preOrden(prueba2);
        boolean fusionables = true; 
        while(!arb1.vacia()){
            if(!arb2.vacia()){
                if(igual(arb1.pop(),arb2.pop()));
                else    fusionables = false;
            }else{
                fusionables = false;
                arb1.pop();
            }
            if(arb1.vacia()){
                if(!arb2.vacia()){
                    fusionables = false;
                    arb2.pop();
                }
            }
        }
        return fusionables;
    }
    
    private boolean igual(int x, int y){
        boolean res = true;
        if(x == -1){
            if(y == -1);
            else    res = false;
        }else{
            if(y == -1){
                if(x == -1);
                else    res = false;
            }
        }
        return res;
    }
}
