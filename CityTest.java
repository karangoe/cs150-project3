
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class CityTest
{
    /**
     * Default constructor for test class CityTest
     */
    Graph g = new Graph();
    ArrayList<Cargo> cargos = new ArrayList<Cargo>();
    Warehouse w = new Warehouse("Easton", cargos, g);
    City c1 = new City("Easton");
    City c2 = new City("New York");
    City c3 = new City("Philly");

    public CityTest()
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

    @Test
    public void testGetName() {
        assertEquals(c1.getName(), "Easton");
        assertEquals(c2.getName(), "New York");
        assertEquals(c3.getName(), "Philly");
    }

    @Test
    public void testSetWarehouse() {
        c1.setWarehouse(w);
        assertTrue(c1.isWarehouse == true);
    }

    @Test
    public void testGetWarehouse() {
        c1.setWarehouse(w);
        assertEquals(c1.getWarehouse(), w);
    }
    
    @Test
    public void testGetNullWarehouse() {
        assertTrue(c2.getWarehouse() == null);
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
}
