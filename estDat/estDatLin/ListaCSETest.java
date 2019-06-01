package estDat.estDatLin;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaCSETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaCSETest
{
    /**
     * Default constructor for test class ListaCSETest
     */
    public ListaCSETest()
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        assertEquals(false, lista.vacia());
    }
    
    @Test
    public void testInsertarDatoEnPos(){
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3, 2);
        assertEquals(true, lista.vacia());
        lista.insertar(3, 0);
        assertEquals(false, lista.vacia());      
    }
    
    @Test
    public void testInsertarDatoIni(){
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertarIni(3);
        assertEquals(false, lista.vacia());
    }
    
    @Test
    public void testEliminarDePos(){
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(4, lista.longitud());
    }
    
    @Test
    public void testBuscarDato(){
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
        ListaCSE<Integer> lista;
        
        lista = new ListaCSE<Integer>();
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
