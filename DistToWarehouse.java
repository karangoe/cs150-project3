
/**
 * Write a description of class DistToWarehouse here.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 03, 2018)
 */
public class DistToWarehouse implements Comparable<DistToWarehouse>
{
    // instance variables - replace the example below with your own
    Warehouse wh;
    int shortestPath;

    /**
     * Constructor for objects of class DistToWarehouse
     */
    public DistToWarehouse(Warehouse _wh, int sp)
    {
        // initialise instance variables
        this.wh = _wh;
        this.shortestPath = sp;
    }

    /**
     * An method that overrides the compareTo method
     */
    @Override
    public int compareTo(DistToWarehouse dist) {
        if((this.shortestPath-dist.shortestPath)!=0)
            return this.shortestPath-dist.shortestPath;
        else return (this.wh.city.getName()).compareTo(dist.wh.city.getName());
    }
    
   
}
