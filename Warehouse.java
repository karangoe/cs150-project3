
/**
 * Write a description of class Warehouse here.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */
import java.util.*;

public class Warehouse {
    private ArrayList<Warehouse> otherWarehouses;
    ArrayList<Integer> shortestPath;
    PriorityQueue<Integer> cargos;
    City city;
    boolean isCenter = false;

    /**
     * Constructor for objects of class Warehouse
     */
    public Warehouse(String name, ArrayList<Integer> _cargos, Graph g)
    {
        otherWarehouses = new ArrayList<Warehouse>();
        shortestPath = new ArrayList<Integer>();
        cargos = new PriorityQueue<Integer>();
        city = g.getCity(name);
        if(_cargos!=null){
            for(int i=0;i<_cargos.size();i++){
                cargos.add(_cargos.get(i));
            }
        }
    }

    /**
     * A method that sets a city as the center
     * @param b indication of whether the city is the center or not
     */
    public void setIsCenter(boolean b){
        isCenter = b;
    }

    /**
     * A method that populates the Array Lists of warehouses and shortest path 
     * @param wh the warehouse to be added
     * @param distance the shortest path to the corresponding warehouse
     */
    public void addOtherWarehouse(Warehouse wh, int distance){
        otherWarehouses.add(wh);
        shortestPath.add(distance);
    }

    /**
     * A method that checks whether the warehouse is empty
     */
    public boolean isEmpty(){
        return cargos.isEmpty();
    }
    
    /**
     * A method that gets other warehouses
     * @return the Array List of warehouses
     */
    
    public ArrayList<Warehouse> getOtherWareHouses(){
        return this.otherWarehouses;
    }
    

}
