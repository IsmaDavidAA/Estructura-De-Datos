package estDat.estDatLin;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaSETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaSETest
{
    /**
     * Default constructor for test class ListaSETest
     */
    public ListaSETest()
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
    /**
     * 
    void insertar(T dato);
    */
    @Test
    public void testInsertarDato(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        assertEquals(false, lista.vacia());
    }
    
    /**
    void insertar(T dato, int pos);
    **/
    @Test
    public void testInsertarDatoEnPos(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3, 2);
        assertEquals(true, lista.vacia());
        lista.insertar(3, 0);
        assertEquals(false, lista.vacia());        
    }
    
    /**
    void insertarIni(T dato);
    */
    @Test
    public void testInsertarDatoIni(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertarIni(3);
        assertEquals(false, lista.vacia());
    }

    /**
    T eliminar(int pos);
    **/
    @Test
    public void testEliminarDePos(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        assertEquals(null, lista.eliminar(10));
        lista.insertar(3);
        assertEquals(null, lista.eliminar(10));
        assertEquals(false, lista.vacia());
        assertEquals(new Integer(3), lista.eliminar(0));
        assertEquals(true, lista.vacia());
        lista.insertar(2);
        lista.insertar(6);
        lista.insertar(54);
        assertEquals(false, lista.vacia());
        assertEquals(new Integer(6), lista.eliminar(1));
    }

    /**
    T eliminar(T dato);
    **/
    @Test
    public void testEliminarDato(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        assertEquals(null, lista.eliminar(10));
        lista.insertar(3);
        assertEquals(null, lista.eliminar(new Integer(0)));
        assertEquals(false, lista.vacia());
        assertEquals(new Integer(3), lista.eliminar(new Integer(3)));
        assertEquals(true, lista.vacia());
        
    }
    /**
    void eliminar(int desde, int hasta);
    **/
    @Test
    public void testEliminarIntervalo(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.eliminar(0, 10);
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        lista.eliminar(10, 12);
        assertEquals(false, lista.vacia());
        lista.eliminar(0,2);
        assertEquals(false, lista.vacia());
        assertEquals(1, lista.longitud());
    }
    /**
    void eliminarTodas(T dato);
    **/
    @Test
    public void testEliminarTodas(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.eliminarTodas(0);
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        lista.insertar(1);
        assertEquals(5, lista.longitud());
        lista.eliminarTodas(1);
        assertEquals(3, lista.longitud());
    }
    /**
    T acceder(int pos);
    **/
    @Test
    public void testAccederPos(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(null, lista.acceder(10));
        assertEquals(false, lista.vacia());
        assertEquals(new Integer(3), lista.acceder(0));
        assertEquals(new Integer(1), lista.acceder(1));
        assertEquals(new Integer(4), lista.acceder(3));
    }
    /**
    T acceder(T dato);
    **/
    @Test
    public void testAccederDato(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
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
    }
    /**
    Lista<T> acceder(int desde, int hasta);
    */
    @Test
    public void testAccederIntervalo(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
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
    /**
    int longitud();
    */
    @Test
    public void testLongitud(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(4, lista.longitud());
    }
    /**
    boolean buscar(T dato);
    */
    @Test
    public void testBuscarDato(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(true, lista.buscar(new Integer(4)));
        assertEquals(false, lista.buscar(new Integer(10)));
    }   
    /**
    int indiceDe(T dato);
     */ 
    @Test
    public void testIndiceDe(){
        ListaSE<Integer> lista;
        
        lista = new ListaSE<Integer>();
        assertEquals(true, lista.vacia());
        lista.insertar(3);
        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        assertEquals(3, lista.indiceDe(new Integer(4)));
        assertEquals(-1, lista.indiceDe(new Integer(10)));
    } 
}
