public class Collar_Ej16
{
    private Pila<Piedra> collar;
    private Cola<Piedra> auxCollar;
    private Cola<Piedra> piedras;
    public Collar_Ej16(){
       piedras = new Cola<Piedra>();
       auxCollar = new Cola<Piedra>();
       collar = new Pila<Piedra>();   
    }
    public String crearCollar(){
        String res;
        while(!piedras.vacia()){
            Piedra piedra = piedras.decolar();
            ingresar(piedra);  
        }
        if(auxCollar.vacia())
            res = imprimir();
        else{
            res = "No es posible";
        }
        return res;
    }
    
    private String imprimir(){
        String res = "";
        while(!collar.vacia()){
            Piedra p = collar.pop();
            res = p.getColor() + res;
        }
        return res;
    }
    
    private void ingresar(Piedra piedra){
        if(collar.vacia())
            collar.push(piedra);
        else{
            if(prohibida(piedra))   auxCollar.encolar(piedra);
            else{
                collar.push(piedra);
                if(!auxCollar.vacia()){
                    Piedra p = auxCollar.decolar();
                    ingresar (p);
                }
            }
        }
    }
    private boolean prohibida(Piedra piedra){
        Piedra ult = collar.top();
        boolean res = false;
        if(ult.getColor().equals(piedra.getColor())) res = true;
            else{
                if(piedra.getColor().equals("negro")){
                    if(ult.getColor().equals("morado") || ult.getColor().equals("naranja")) res = true;
                }else   if(piedra.getColor().equals("morado")){
                            if(ult.getColor().equals("negro")) 
                            res = true;
                }else   if(piedra.getColor().equals("naranja")){
                            if(ult.getColor().equals("negro")) res = true;
            }
        }
        return res;
    }
    
    public void ingresarPiedra(Piedra nueva){
        piedras.encolar(nueva);
    }
}
