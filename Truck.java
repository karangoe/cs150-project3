
/**
 * Write a description of class Truck here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
