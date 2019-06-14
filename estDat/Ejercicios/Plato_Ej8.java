public class Plato_Ej8
{
    private Pila<Panqueque> panqueques;
    public Plato_Ej8(){
       panqueques = new Pila<Panqueque>();
    }
    public void setPanqueques(Pila<Panqueque> panqueque){
        this.panqueques = panqueques;
    }
    
    public Pila<Panqueque> getPanqueques(){
        return panqueques;
    }
    
    public void addPanqueque(Panqueque nuevo){
        Pila<Panqueque> aux = new Pila<Panqueque>();
        Panqueque ult; 
        boolean posicionado = false;
        if(panqueques.top()!=null){
            do{
                ult = panqueques.pop();
                if(ult.getTamaño() >= nuevo.getTamaño()){
                    posicionado = true;
                    panqueques.push(ult);
                }else{
                    aux.push(ult);
                }
            }while(posicionado == false && panqueques.top()!=null);
            panqueques.push(nuevo);
            while(aux.top() != null){
                ult = aux.pop();
                panqueques.push(ult);
            }
        }else{
            panqueques.push(nuevo);
        }
    }
    
    public Panqueque ultimo(){
        return panqueques.top();
    }
}
