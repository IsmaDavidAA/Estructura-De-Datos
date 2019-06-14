



public class Torre_Ej24
{
    private Pila<Bloque> torre;
    private int altura;
    public Torre_Ej24(){
        torre = new Pila<Bloque>();
        altura = 0;
    }
    
    public void insertar(Bloque canino){
        if(torre.vacia()){
            torre.push(canino);
            altura++;
        }else{
            if(torre.top() instanceof BloqueMadera){
                BloqueMadera ultimoCanino = (BloqueMadera)torre.pop();
                if(torre.vacia()){
                    torre.push(ultimoCanino);
                    torre.push(canino);
                    altura++;
                }else{
                    if(canino instanceof BloqueMadera && torre.top() instanceof BloqueMadera)   torre.push(ultimoCanino);
                    else{
                        torre.push(ultimoCanino);
                        torre.push(canino);
                        altura++;
                    }
                }
            }else{
                BloquePiedra ultimoCanino = (BloquePiedra)torre.pop();
                if(torre.vacia()){
                    torre.push(ultimoCanino);
                    torre.push(canino);
                    altura++;
                }else{
                    if(canino instanceof BloquePiedra && torre.top() instanceof BloquePiedra)   torre.push(ultimoCanino);
                    else{
                        torre.push(ultimoCanino);
                        torre.push(canino);
                        altura++;
                    }
                }
            }
        }
    }
    
    public boolean vacia(){
        return torre.vacia();
    }
    public Integer getAltura(){
        return altura;
    }
}