package estDat.estDatLin;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaCDETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaCDETest
{
    /**
     * Default constructor for test class ListaCDETest
     */
    public ListaCDETest()
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
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        assertEquals(false, lista.vacia());
    }
    
    @Test
    public void testInsertarDatoEnPos(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3, 2);
        assertEquals(true, lista.vacia());
        lista.insertar(3, 0);
        assertEquals(false, lista.vacia());      
    }
    
    @Test
    public void testInsertarDatoIni(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertarIni(3);
        assertEquals(false, lista.vacia());
    }
    
    @Test
    public void testEliminarDePos(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        assertEquals(null, lista.eliminar(10));
        lista.insertar(3);
        assertEquals(new Integer(3), lista.eliminar(10));
        assertEquals(true, lista.vacia());
        assertEquals(null, lista.eliminar(0));
        assertEquals(true, lista.vacia());
        lista.insertar(2);
        lista.insertar(6);
        lista.insertar(54);
        assertEquals(false, lista.vacia());
        assertEquals(new Integer(6), lista.eliminar(4));
    }
    
    @Test
    public void testEliminarDato(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        assertEquals(null, lista.eliminar(10));
        lista.insertar(3);
        assertEquals(new Integer(3), lista.eliminar(new Integer(3)));
        assertEquals(true, lista.vacia());
        assertEquals(null, lista.eliminar(new Integer(3)));
        assertEquals(true, lista.vacia());
        
    }
    
    @Test
    public void testEliminarTodas(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.eliminarTodas(0);
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        lista.insertar(1);
        lista.insertar(2);
        assertEquals(6, lista.longitud());
        lista.eliminarTodas(1);
        assertEquals(4, lista.longitud());
    }
    
    @Test
    public void testAccederPos(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(new Integer(5), lista.acceder(10));
        assertEquals(false, lista.vacia());
        assertEquals(new Integer(3), lista.acceder(0));
        assertEquals(new Integer(1), lista.acceder(1));
        assertEquals(new Integer(4), lista.acceder(3));
    }
    
    @Test
    public void testAccederDato(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(null, lista.acceder(new Integer(10)));
        assertEquals(false, lista.vacia());
        assertEquals(null, lista.acceder(new Integer(0)));
        assertEquals(new Integer(1), lista.acceder(new Integer(1)));
        assertEquals(new Integer(3), lista.acceder(new Integer(3)));
        assertEquals(new Integer(4), lista.acceder(new Integer(4)));
        
    }
    
    @Test
    public void testLongitud(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(4, lista.longitud());
    }
    
    @Test
    public void testBuscarDato(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(true, lista.buscar(new Integer(4)));
        assertEquals(false, lista.buscar(new Integer(10)));
    }   
    
    @Test
    public void testIndiceDe(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(3, lista.indiceDe(new Integer(4)));
        assertEquals(-1, lista.indiceDe(new Integer(10)));
    } 
    
    @Test
    public void testEliminarIntervalo(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.eliminar(0, 10);
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        lista.eliminar(10, 12);
        assertEquals(false, lista.vacia());
        lista.eliminar(1,3);
        assertEquals(false, lista.vacia());
        assertEquals(1, lista.longitud());
        assertEquals(true, lista.buscar(new Integer(3)));
    }
    
    @Test
    public void testAccederIntervalo(){
        ListaCDE<Integer> lista;
        
        lista = new ListaCDE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(null, lista.acceder(10, 12));
        assertEquals(false, lista.vacia());
        assertNotNull(lista.acceder(0, 3));
        assertEquals(false, lista.vacia());
        
    }
}
