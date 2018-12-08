
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WarehouseTest.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 06, 2018)
 */

import java.util.ArrayList;

public class WarehouseTest
{
    /**
     * Default constructor for test class WarehouseTest
     */
    
    Graph g = new Graph();
    ArrayList<Cargo> cargos = new ArrayList<Cargo>();
    Warehouse w0 = new Warehouse("w0", cargos, g);
    
    Warehouse w1 = new Warehouse("w1", cargos, g);
    Warehouse w2 = new Warehouse("w2", cargos, g);
    Warehouse w3 = new Warehouse("w3", cargos, g);
    Warehouse w4 = new Warehouse("w4", cargos, g);
    Warehouse w5 = new Warehouse("w5", cargos, g);
 
    
    public WarehouseTest()
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
    public void testMakeCenter() {
        w0.makeCenter();
        assertTrue(w0.isCenter == true);
    }
    
    @Test
    public void testAddOtherDistances() {
        w0.addOtherDistances(w1, 32);
        w0.addOtherDistances(w2, 54);
        w0.addOtherDistances(w3, 25);
        w0.addOtherDistances(w4, 63);
        w0.addOtherDistances(w5, 15);
        
        assertTrue(w0.distances.size() == 5);
        
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
