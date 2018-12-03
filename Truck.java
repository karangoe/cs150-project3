
/**
 * Write a description of class Truck here.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */
import java.util.*;
public class Truck
{
    public int distTraveled = 0;
    public City location;
    public int weightLeft = 500;
    private ArrayList<Integer> cargos = new ArrayList<Integer>();

    /**
     * Constructor for objects of class Truck
     */
    public Truck(City _location)
    {
        location = _location;
    }

    public void addCargo(int cargo){
        cargos.add(cargo);
    }
}
