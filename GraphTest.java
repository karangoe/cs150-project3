
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class GraphTest.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 07, 2018)
 */
public class GraphTest
{
    /**
     * Default constructor for test class GraphTest
     */
    Graph g = new Graph();
    String city1 = "A";
    String city2 = "B";
    String city3 = "C";

    ArrayList<Cargo> cargos1 = new ArrayList<Cargo>();
    ArrayList<Cargo> cargos2 = new ArrayList<Cargo>();
    Cargo cargo1 = new Cargo(0, 35);
    Cargo cargo2 = new Cargo(1, 35);
    Cargo cargo3 = new Cargo(2, 70);
    Cargo cargo4 = new Cargo(3, 56);
    Warehouse w1;
    Warehouse w2;
    Warehouse w3;

    public GraphTest()
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
    public void testGetCity() {
        g.getCity(city1);
        g.getCity(city2);
        assertTrue(g.vertexMap.size() == 2);
    }

    @Test
    public void testAddEdge() {
        g.addEdge(city1, city2, 0);
        g.addEdge(city1, city3, 0);
        assertTrue(g.getCity(city1).nbs.size() == 2);
    }

    @Test
    public void testDijkstra() {
        City easton = g.getCity(city1);
        City newYork = g.getCity(city2);
        City philly = g.getCity(city3);

        g.addEdge(city1, city2, 35);
        g.addEdge(city1, city3, 45);
        g.addEdge(city2, city3, 100);

        w1 = new Warehouse(city1, cargos1, g);
        w2 = new Warehouse(city2, cargos2, g);
        w3 = new Warehouse(city3, cargos1, g);

        easton.setWarehouse(w1);
        newYork.setWarehouse(w2);
        philly.setWarehouse(w3);

        g.dijkstra(w1.city);
        g.dijkstra(w2.city);
        g.dijkstra(w3.city);

        ArrayList<String> result1 = w1.returnString();
        ArrayList<String> expected1 = new ArrayList<String>();
        expected1.add("Warehouse at: B is 35 dist away.");
        expected1.add("Warehouse at: C is 45 dist away.");

        ArrayList<String> result2 = w2.returnString();
        ArrayList<String> expected2 = new ArrayList<String>();
        expected2.add("Warehouse at: A is 35 dist away.");
        expected2.add("Warehouse at: C is 80 dist away.");

        ArrayList<String> result3 = w3.returnString();
        ArrayList<String> expected3 = new ArrayList<String>();
        expected3.add("Warehouse at: A is 45 dist away.");
        expected3.add("Warehouse at: B is 80 dist away.");

        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);

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
