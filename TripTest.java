
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class TripTest.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 06, 2018)
 */
public class TripTest
{
    /**
     * Default constructor for test class TripTest
     */
    Graph g = new Graph();
    ArrayList<Cargo> cargos = new ArrayList<Cargo>();
    Warehouse w = new Warehouse("warehouse", cargos, g); 
    Shipment s1 = new Shipment(w, 63);
    Shipment s2 = new Shipment(w, 90);
    Shipment s3 = new Shipment(w, 24);
    Shipment s4 = new Shipment(w, 18);
    Shipment s5 = new Shipment(w, 37);
    Trip trip = new Trip();

    public TripTest()
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
    public void testAddShipment() {
        trip.addShipment(s1);
        trip.addShipment(s2);
        trip.addShipment(s3);
        trip.addShipment(s4);
        trip.addShipment(s5);
        assertTrue(trip.shipment.size() == 5);
    }

    @Test
    public void testSetWayBack() {
        trip.setWayBack(52);
        assertTrue(trip.wayBack == 52);
    }

    @Test
    public void testTotalDistance() {
        trip.setWayBack(52);
        trip.addShipment(s1);
        trip.addShipment(s2);
        trip.addShipment(s3);
        trip.addShipment(s4);
        trip.addShipment(s5);
        int expected = trip.totalDistance();
        int result = 52+63+90+24+18+37;
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
