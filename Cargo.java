
/**
 * Write a description of class Cargo here.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */
import java.util.*;
public class Cargo implements Comparable<Cargo> {
    public int num; //ID of the cargo
    int weight; 

    /**
     * Constructor for objects of class Cargo
     */
    public Cargo(int n, int w)
    {
        num = n+1;
        weight = w;
    }

    /**
     * An method that overrides the compareTo method
     */
    @Override
    public int compareTo(Cargo c) {
        return this.weight - c.weight;
    }

    /**
     * A method that gets the weight of a cargo
     * @return the weight of the cargo
     */
    public int getWeight() {
        return this.weight;
    }
}
