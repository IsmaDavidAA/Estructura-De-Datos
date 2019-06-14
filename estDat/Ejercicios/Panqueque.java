package estDat.Ejercicios;



public class Panqueque
{
    private int tamaño;
    public Panqueque(int tamaño){
       this.tamaño = tamaño;
    }

    public Panqueque(){
        tamaño = 0;
    }
    
    public void setTamaño(int tamaño){
        this.tamaño = tamaño;
    }
    
    public int getTamaño(){ 
        return tamaño;
    }
}


