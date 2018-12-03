
/**
 * Write a description of class Warehouse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Warehouse
{
    ArrayList<Warehouse> otherWarehouses;
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
        city = g.getVertex(name);
        if(_cargos!=null){
            for(int i=0;i<_cargos.size();i++){
                cargos.add(_cargos.get(i));
            }
        }
    }
    
    public void setIsCenter(boolean b){
        isCenter = b;
    }
     
    public void addOtherWarehouse(Warehouse wh, int distance){
        otherWarehouses.add(wh);
        shortestPath.add(distance);
    }
    
    public boolean isEmpty(){
        return cargos.isEmpty();
    }

}
