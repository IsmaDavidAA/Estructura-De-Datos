package estDat.Ejercicios;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SeparadorDeListas_Ej23Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SeparadorDeListas_Ej23Test
{
    /**
     * Default constructor for test class SeparadorDeListas_Ej23Test
     */
    public SeparadorDeListas_Ej23Test()
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
        SeparadorDeListas_Ej23 separador;
        separador = new SeparadorDeListas_Ej23();
        separador.ingresarNum(1);
        separador.ingresarNum(8);
        separador.ingresarNum(1);
        separador.ingresarNum(7);
        separador.ingresarNum(5);
        separador.repartir(6);
        assertEquals("151", separador.imprMenores());
        assertEquals("87", separador.imprMayores());
    }
}
