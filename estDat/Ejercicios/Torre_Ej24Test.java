package estDat.Ejercicios;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Torre_Ej24Test
{
    /**
     * Default constructor for test class Torre_Ej24Test
     */
    public Torre_Ej24Test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    
    @Test
    public void testDSeparador(){
        Torre_Ej24 torre;
        torre = new Torre_Ej24();
        
        assertEquals(true, torre.vacia());
        torre.insertar(new BloqueMadera());
        assertEquals(false, torre.vacia());
        torre.insertar(new BloqueMadera());
        torre.insertar(new BloqueMadera());
        torre.insertar(new BloqueMadera());
        assertEquals(new Integer(2), torre.getAltura());
        torre.insertar(new BloquePiedra());
        torre.insertar(new BloqueMadera());
        torre.insertar(new BloqueMadera());
        torre.insertar(new BloquePiedra());
        assertEquals(new Integer(6), torre.getAltura());
    }
    

}
