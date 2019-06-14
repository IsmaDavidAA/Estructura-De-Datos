
/**
 * Write a description of class Ej_31_EDNL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ej_31_EDNL
{
    ArbolBin<Integer> prueba;
    ArbolBin<Integer> prueba2;
    public Ej_31_EDNL(){
        prueba = new ArbolBin<Integer>();
        prueba2 = new ArbolBin<Integer>();
        llenarArbol();
    }
    
    private void llenarArbol(){
        prueba.insertarPorAmplitud(5);
        prueba.insertarPorAmplitud(4);
        prueba.insertarPorAmplitud(8);
        prueba.insertarPorAmplitud(11);
        
        prueba2.insertarPorAmplitud(6);
        prueba2.insertarPorAmplitud(9);
        prueba2.insertarPorAmplitud(244);
        prueba2.insertarPorAmplitud(41);
    }
    
    
    public boolean fusionables(){
        boolean fusionables = true;
        String arb1 = prueba.toStringX();
        String arb2 = prueba2.toStringX();
        if(arb1.length() == arb2.length()){
            char arr1[] = arb1.toCharArray();
            char arr2[] = arb2.toCharArray();
            for(int i = 0; i <arr1.length;i++){
                if(arr1[i] == '-'){
                    if(arr1[i] == arr2[i]);
                    else    fusionables = false;
                }
            }
        }else   fusionables = false;
        return fusionables;
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
}
