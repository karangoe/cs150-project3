
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class DistToWarehouseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DistToWarehouseTest
{
    /**
     * Default constructor for test class DistToWarehouseTest
     */

    Graph g = new Graph();
    ArrayList<Cargo> cargos = new ArrayList<Cargo>();

    Warehouse w1 = new Warehouse("A", cargos, g);
    Warehouse w2 = new Warehouse("B", cargos, g);
    Warehouse w3 = new Warehouse("C", cargos, g);


    DistToWarehouse d1 = new DistToWarehouse(w1, 40);
    DistToWarehouse d2 = new DistToWarehouse(w1, 30);
    DistToWarehouse d3 = new DistToWarehouse(w1, 50);
    DistToWarehouse d4 = new DistToWarehouse(w2, 40);
    DistToWarehouse d5 = new DistToWarehouse(w3, 40);
    DistToWarehouse d6 = new DistToWarehouse(w1, 40);
    public DistToWarehouseTest()
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
    public void compareLongerDist() {
        assertTrue(d1.compareTo(d2) > 0);

    }

    @Test 
    public void compareShorterDist() {
        assertTrue(d1.compareTo(d3) < 0);
    }

    @Test
    public void compareSameDistSmallerName() {
        assertTrue(d1.compareTo(d4) < 0);
    }
    
    @Test
    public void compareSameDistBiggerName() {
        assertTrue(d5.compareTo(d4) > 0);
    }
    
    @Test
    public void compareSameDistSameName() {
        assertTrue(d1.compareTo(d6) == 0);
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
