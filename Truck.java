
/**
 * Write a description of class Truck here.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 03, 2018)
 */
import java.util.*;
public class Truck
{
    private City location;
    public int weightLeft = 500; //Maximum capacity of the truck
    ArrayList<Trip> trip; //List of trips

    /**
     * Constructor for objects of class Truck
     */
    public Truck(City _location)
    {
        trip = new ArrayList<Trip>();
        location = _location;
    }

    /**
     * A method that add a trip to the truck
     *
     * @param  t  the trip to be added
     */
    public void addTrip(Trip t){
        trip.add(t);
    }

    /**
     * A method that gets the list of trips
     * @return the Array List of Trips
     */

    public ArrayList<Trip> getTrips(){
        return this.trip;
    }

    /**
     * A method that gets number of trips
     * @return int the number of trips
     */

    public int getNumOfTrips(){
        return this.trip.size();
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
