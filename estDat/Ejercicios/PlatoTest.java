

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlatoTest
{
    /**
     * Default constructor for test class PlatoTest
     */
    public PlatoTest()
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
    public void testInsertarDato(){
        Plato_Ej8 plato;
        
        plato = new Plato_Ej8();
        Panqueque p1 = new Panqueque(3);
        Panqueque p2 = new Panqueque(6);
        Panqueque p3 = new Panqueque(1);
        Panqueque p4 = new Panqueque(3);
        assertEquals(null, plato.ultimo());
        plato.addPanqueque(p1);
        plato.addPanqueque(p2);
        plato.addPanqueque(p3);
        plato.addPanqueque(p4);
        Panqueque p5 = plato.ultimo();
        int tamaño = p5.getTamaño();
        assertEquals(tamaño, tamaño);
    }
    
   
}
