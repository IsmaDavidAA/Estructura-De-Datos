

public class SeparadorDeListas_Ej23{
    private ListaCSE<Integer> menores;
    private ListaCSE<Integer> mayores;
    private ListaCSE<Integer> entrada;
    public SeparadorDeListas_Ej23(){
        menores = new ListaCSE<Integer>();
        mayores = new ListaCSE<Integer>();
        entrada = new ListaCSE<Integer>();
    }
    public void repartir(Integer n){
        int pos = entrada.longitud();
        repartir(n,pos);
    }
    private void repartir(Integer n ,int pos){
        while (pos > 0){
            Integer p = entrada.acceder(pos);
            if(n<=p)    mayores.insertar(p);
            else    menores.insertar(p);
            pos --;
        }
    }
    public void ingresarNum(int num){
         entrada.insertar(num);
    }

    public String imprMenores(){
        String res = "";
        for(int i = 0; i <menores.longitud();i++){
            res = menores.acceder(i) + res;
        }
        return res;
    }
    
    public String imprMayores(){
        String res = "";
        for(int i = 0; i <mayores.longitud();i++){
            res = mayores.acceder(i) + res;
        }
        return res;
    }
}
