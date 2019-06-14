


public class Ej_11_EDNL
{
    ArbolBB<Integer> prueba;
    public Ej_11_EDNL(){
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
    
    public BiCola<Integer> encontrarCamino(int desde,int hasta){
        ArbolBB<Integer> origen = encontrarRaiz(desde,hasta,this.prueba);
        BiCola<Integer> rama1 = origen.recogerEnBiCola(desde); 
        BiCola<Integer> rama2 = origen.recogerEnBiCola(hasta);
        BiCola<Integer> ruta = new BiCola<Integer>();
        while(!rama1.vacia()) ruta.encolar(rama1.decolarFin());
        rama2.decolar();
        while(!rama2.vacia()) ruta.encolar(rama2.decolar());
        return ruta;
    }
    
    private ArbolBB<Integer> encontrarRaiz(int desde,int hasta,ArbolBB<Integer> nuevo){
        if(!nuevo.vacia()){
            if (desde <= nuevo.getRaiz() && hasta >= nuevo.getRaiz());
            else{
                if(hasta <= nuevo.getRaiz())    nuevo = encontrarRaiz(desde,hasta,nuevo.getIzq());
                else    nuevo = encontrarRaiz(desde,hasta,nuevo.getDer());
            }
        }
        return nuevo;
    }
    
}
