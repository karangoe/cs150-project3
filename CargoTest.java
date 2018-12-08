
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CargoTest.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 06, 2018)
 */
public class CargoTest
{
    Cargo c1 = new Cargo(0, 35);
    Cargo c2 = new Cargo(1, 35);
    Cargo c3 = new Cargo(2, 70);
    Cargo c4 = new Cargo(3, 56);
    /**
     * Default constructor for test class CargoTest
     */
    public CargoTest()
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
    public void testGetWeight() {
        assertTrue(c1.getWeight() == 35);
    }

    @Test
    public void testCompareEqualCargos() {
        int expected = c1.compareTo(c2);
        assertTrue(expected == 0);
    }
    
    @Test
    public void testCompareLighterCargo() {
        int expected = c1.compareTo(c3);
        assertTrue(expected < 0);
        
    }
    
    @Test
    public void testCompareHeavierCargo() {
        int expected = c3.compareTo(c4);
        assertTrue(expected > 0);
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
