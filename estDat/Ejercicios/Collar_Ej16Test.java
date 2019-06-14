package estDat.Ejercicios;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Collar_Ej16Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Collar_Ej16Test
{
    /**
     * Default constructor for test class Collar_Ej16Test
     */
    public Collar_Ej16Test()
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
    public void testCrearCollarCorrecto(){
        Collar_Ej16 collar;
        collar = new Collar_Ej16();
        Piedra p1 = new Piedra("morado");
        Piedra p2 = new Piedra("negro");
        Piedra p3 = new Piedra("negro");
        Piedra p4 = new Piedra("morado");
        Piedra p5 = new Piedra("verde");
        Piedra p6 = new Piedra("verde");
        Piedra p7 = new Piedra("amarillo");
        Piedra p8 = new Piedra("naranja");
        Piedra p9 = new Piedra("blanco");
        Piedra p10 = new Piedra("rojo");
        collar.ingresarPiedra(p1);
        collar.ingresarPiedra(p2);
        collar.ingresarPiedra(p3);
        collar.ingresarPiedra(p4);
        collar.ingresarPiedra(p5);
        collar.ingresarPiedra(p6);
        collar.ingresarPiedra(p7);
        collar.ingresarPiedra(p8);
        collar.ingresarPiedra(p9);
        collar.ingresarPiedra(p10);
        String collarSaliente = "moradoverdenegroverdemoradoamarillonegroblanconaranjarojo";
        assertEquals(collarSaliente, collar.crearCollar());
    }
    
    @Test
    public void testCrearCollarIncorrecto(){
        Collar_Ej16 collar;
        collar = new Collar_Ej16();
        Piedra p1 = new Piedra("morado");
        Piedra p2 = new Piedra("negro");
        Piedra p3 = new Piedra("verde");
        Piedra p4 = new Piedra("morado");
        Piedra p5 = new Piedra("verde");
        Piedra p6 = new Piedra("negro");
        Piedra p7 = new Piedra("negro");
        Piedra p8 = new Piedra("morado");
        collar.ingresarPiedra(p1);
        collar.ingresarPiedra(p2);
        collar.ingresarPiedra(p3);
        collar.ingresarPiedra(p4);
        collar.ingresarPiedra(p5);
        collar.ingresarPiedra(p6);
        collar.ingresarPiedra(p7);
        collar.ingresarPiedra(p8);
        String collarSaliente = "No es posible";
        assertEquals(collarSaliente, collar.crearCollar());
    }
    
    
    
    
    
}
