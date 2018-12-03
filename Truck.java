
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
    private City location;
    public int weightLeft = 500;
    private ArrayList<Integer> cargos = new ArrayList<Integer>();

    /**
     * Constructor for objects of class Truck
     */
    public Truck(City _location)
    {
        location = _location;
    }

    /**
     * A method that add a cargo onto the truck
     *
     * @param  cargo  the weight of the cargo added
     */
    public void addCargo(int cargo){
        cargos.add(cargo);
    }
    
    /**
     * A method that gets the location of the truck
     */
    public City getLocation() {
        return this.location;
    }
    
    /**
     * A method that sets the location of the truck
     */
    public void setLocation(City c) {
        this.location = c;
    }
   
    
}
