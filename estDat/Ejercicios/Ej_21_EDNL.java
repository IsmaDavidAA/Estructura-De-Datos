package estDat.Ejercicios;


/**
 * Write a description of class Ej_21_EDNLç here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ej_21_EDNL
{
    ArbolBB<Integer> prueba;
    public Ej_21_EDNL(){
        prueba = new ArbolBB<Integer>();
        llenarPrueba();
    }
    
    private void llenarPrueba(){
        prueba.insertar(60);
        prueba.insertar(30);
        prueba.insertar(63);
        prueba.insertar(20);
        prueba.insertar(54);
        prueba.insertar(74);/*
        prueba.insertar(18);
        prueba.insertar(42);
        prueba.insertar(10);
        prueba.insertar(35);
        prueba.insertar(47);
        prueba.insertar(40);
        prueba.insertar(70);
        prueba.insertar(87);
        prueba.insertar(91);*/
    }
    
    public ListaSE<Integer> sacarMedia(){
        ListaSE<BiCola<Integer>> lista = prueba.RecogerRamasDelArbolenBiCola(); 
        BiCola<Integer> menor = new BiCola<Integer>(lista.acceder(0));
        BiCola<Integer> mayor = new BiCola<Integer>(lista.acceder(0));
        ListaSE<Integer> res = new ListaSE<Integer>();
        for(int i = 0; i <= lista.longitud(); i++)  menor = calcularMenor(menor,lista.acceder(1+i));
        for(int i = 0; i <= lista.longitud(); i++)  mayor = calcularMenor(mayor,lista.eliminar(1+i));
        res = media(menor,mayor);
        return res;
    }
    
    public ListaSE<Integer> media(BiCola<Integer> menor,BiCola<Integer> mayor){
        ListaSE<Integer> nueva = new ListaSE<Integer>();
        while(!menor.vacia() && !mayor.vacia()){
            while(!menor.vacia() && !menor.vacia()) nueva.insertar((menor.decolar()+mayor.decolar())/2);
            if(menor.vacia()){
                if(mayor.vacia());
                else while(!mayor.vacia()) nueva.insertar(mayor.decolar());
            }else{
                if(!mayor.vacia());
                else while(!menor.vacia()) nueva.insertar(menor.decolar());
            }
        }
        return nueva;
    }
    
    public ListaSE<BiCola<Integer>> lista(){
        return  prueba.RecogerRamasDelArbolenBiCola();
    }

    public BiCola<Integer> calcularMenor(BiCola<Integer> primera,BiCola<Integer> segunda){
        BiCola<Integer> nueva = new BiCola<Integer>();
        while(!primera.vacia() && !segunda.vacia()){
            if(primera.verIni() <= segunda.verIni())    nueva.encolar((primera.decolar()));
            
            if(primera.vacia()){
                if(segunda.vacia());
                else while(!segunda.vacia()) nueva.encolar(segunda.decolar());
            }else{
                if(!segunda.vacia());
                else while(!primera.vacia()) nueva.encolar(primera.decolar());
            }
        }
        return nueva; 
    }
    
    public BiCola<Integer> calcularMayor(BiCola<Integer> primera,BiCola<Integer> segunda){
        BiCola<Integer> nueva = new BiCola<Integer>();
        while(!primera.vacia() && !segunda.vacia()){
            if(primera.verIni() >= segunda.verIni())    nueva.encolar((primera.decolar()));
            
            if(primera.vacia()){
                if(segunda.vacia());
                else while(!segunda.vacia()) nueva.encolar(segunda.decolar());
            }else{
                if(!segunda.vacia());
                else while(!primera.vacia()) nueva.encolar(primera.decolar());
            }
        }
        return nueva; 
    }
}
