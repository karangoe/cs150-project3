
/**
 * Write a description of class Warehouse here.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */
import java.util.*;

public class Warehouse {

    ArrayList<DistToWarehouse> distances; //List of shortest distances to other warehouses
    PriorityQueue<Cargo> cargos; //Priority queue of cargos in the warehouse
    City city;
    boolean isCenter = false; //Check whether the warehouse is located at the center

    /**
     * Constructor for objects of class Warehouse
     */

    public Warehouse(String name, ArrayList<Cargo> _cargos, Graph g)
    {
        cargos = new PriorityQueue<Cargo>();
        distances = new ArrayList<DistToWarehouse>();
        city = g.getCity(name);
        if(_cargos!=null){
            for(Cargo _c: _cargos) {
                Cargo c = _c;
                cargos.add(c);
            }
        }
    }

    /**
     * A method that sets a city as the center
     */
    public void makeCenter() {
        this.isCenter = true;
    }

    /**
     * A method that populates the Array Lists of warehouses and shortest path 
     * @param wh the warehouse to be added
     * @param distance the shortest path to the corresponding warehouse
     */
    public void addOtherDistances(Warehouse wh, int distance){
        DistToWarehouse dtw = new DistToWarehouse(wh,distance);
        distances.add(dtw);
    }

    /**
     * A method that checks whether the warehouse is empty
     */
    public boolean isEmpty(){
        return cargos.isEmpty();
    }

    /**
     * A method that returns a string for Dijkstra unit testing
     * @return ArrayList<String> of shortest paths to other warehouses 
     */
    public ArrayList<String> returnString() {
        ArrayList<String> result = new ArrayList<String>();
        for(DistToWarehouse dtw : distances) {
            String str = " ";
            str = "Warehouse at: " + dtw.wh.city.getName() + " is " + dtw.shortestPath + " dist away.";
            result.add(str);
        }
        return result;
    }

}
