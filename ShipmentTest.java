
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShipmentTest.
 *
 * @author  (Elene Karangozishvili & Trang Le)
 * @version (Dec 06, 2018)
 */
import java.util.ArrayList;
public class ShipmentTest
{
    /**
     * Default constructor for test class ShipmentTest
     */
    Graph g = new Graph();
    ArrayList<Cargo> cargos = new ArrayList<Cargo>();
    Warehouse w = new Warehouse("warehouse", cargos, g); 
    Shipment s = new Shipment(w, 0);
    Cargo c1 = new Cargo(0, 456);
    Cargo c2 = new Cargo(1, 235);
    Cargo c3 = new Cargo(2, 86);
    Cargo c4 = new Cargo(3, 775);

    public ShipmentTest() {
     
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
    public void testAddCargo() {
        s.addCargo(c1);
        s.addCargo(c2);
        s.addCargo(c3);
        s.addCargo(c4);
        assertTrue(s.cargos.size() == 4);
    }

    @Test 
    public void testTotalWeightEmpty() {
        assertTrue(s.totalWeight()==0);
    }

    @Test
    public void testTotalWeight() {
        s.addCargo(c1);
        s.addCargo(c2);
        s.addCargo(c3);
        s.addCargo(c4);
        int expected = s.totalWeight();
        int result = 456+235+86+775;
        assertTrue(expected == result);

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
