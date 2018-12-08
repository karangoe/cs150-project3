
/**
 * City is equivalent to a Vertex in Graph.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */

import java.util.*;

class City implements Comparable<City> {
    private String name;
    List<Road> nbs = new ArrayList<Road>();
    int dist = Integer.MAX_VALUE;
    boolean visited = false;
    private Warehouse warehouse = null;
    City prev;
    boolean isWarehouse = false;

    public City(String n) {
        name = n;
    }

    /**
     * An method that overrides the compareTo method
     */
    @Override
    public int compareTo(City v) {
        return dist - v.dist;
    }

    /**
     * A method that gets the warehouse in a city
     * @return the warehouse placed in the city
     */
    public Warehouse getWarehouse(){
        return this.warehouse;
    }

    /**
     * A method that sets up the warehouse in a city
     * @param  wh  the warehouse to be placed in the city
     */
    public void setWarehouse(Warehouse wh){
        this.warehouse = wh;
        this.isWarehouse = true;
    }

    /**
     * A method that gets the name of the city
     * @return name of the city
     */
    public String getName() {
        return this.name;
    }
}