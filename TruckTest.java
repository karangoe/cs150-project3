
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class TruckTest.
 *
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 06, 2018)
 */
public class TruckTest
{
    /**
     * Default constructor for test class TruckTest
     */

    City c1 = new City("Easton");
    City c2 = new City("New York");
    City c3 = null;
    Trip trip1 = new Trip();
    Trip trip2 = new Trip();
    Trip trip3 = new Trip();
    Trip trip4 = new Trip();
    Trip trip5 = new Trip();
    Truck truck = new Truck(c1);

    public TruckTest()
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
    public void testGetLocation() {
        assertEquals(truck.getLocation(), c1);
    }

    @Test
    public void testSetLocation() {
        truck.setLocation(c2);
        assertEquals(truck.getLocation(), c2);
    }

    @Test
    public void testSetLocationNull() {
        truck.setLocation(c3);
        assertEquals(truck.getLocation(), null);
    }

    @Test
    public void testGetTripsEmpty() {
        ArrayList<Trip> arr = new ArrayList<Trip>();
        assertEquals(truck.getTrips(), arr);
    }
    
    @Test 
    public void testGetNumOfTripsEmpty() {
        assertEquals(truck.getNumOfTrips(), 0);
    }
        

    @Test
    public void testAddTrip() {
        truck.addTrip(trip1);
        truck.addTrip(trip2);
        truck.addTrip(trip3);
        truck.addTrip(trip4);
        truck.addTrip(trip5);
        assertTrue(truck.getTrips().size() == 5);

    }
    
    @Test
    public void testGetNumOfTrips() {
        truck.addTrip(trip1);
        truck.addTrip(trip2);
        truck.addTrip(trip3);
        truck.addTrip(trip4);
        truck.addTrip(trip5);
        assertEquals(truck.getNumOfTrips(), 5);
    }

    @Test
    public void testGetTrips() {
        ArrayList<Trip> arr = new ArrayList<Trip>();
        arr.add(trip1);
        arr.add(trip2);
        arr.add(trip3);
        arr.add(trip4);
        arr.add(trip5);
        truck.addTrip(trip1);
        truck.addTrip(trip2);
        truck.addTrip(trip3);
        truck.addTrip(trip4);
        truck.addTrip(trip5);
        assertEquals(truck.getTrips(), arr);
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
