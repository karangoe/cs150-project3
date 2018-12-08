
/**
 * Trip is a delivery that a truck makes with all the cargos within max capacity.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 03, 2018)
 */
import java.util.*;

public class Trip
{
    int wayBack; //Distance from destination to centere
    ArrayList<Shipment> shipment; //List of shipments in a trip

    /**
     * Constructor for objects of class Trip
     */
    public Trip()
    {
        shipment = new ArrayList<Shipment>();
    }

    /**
     * A method that sets the distance the truck 
     * has to travel back to the center
     *
     * @param  wb  the distance to travel
     */
    public void setWayBack(int wb)
    {
        wayBack = wb;
    }

    /**
     * A method that adds a shipment to a trip
     *
     * @param  s  the shipment to be added
     */
    public void addShipment(Shipment s){
        shipment.add(s);
    }

    /**
     * A method that calculates the total distance 
     * traveled in a trip
     */
    public int totalDistance(){
        int tDistance = 0;
        for (Shipment s:shipment) tDistance += s.traveled;
        tDistance +=wayBack;
        return tDistance;
    }
}
