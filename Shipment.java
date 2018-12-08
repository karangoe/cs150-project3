
/**
 * Shipment is all the cargos delivered to the same warehouse within one trip.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */
import java.util.*;
public class Shipment
{
    public Warehouse wh;
    public ArrayList<Cargo> cargos;
    public int traveled;

    /**
     * Constructor for objects of class Shipment
     */
    public Shipment(Warehouse _wh, int _traveled)
    {
        cargos = new ArrayList<Cargo>();
        wh = _wh;
        traveled = _traveled;
    }

    /**
     * A method that add a cargo to the shipment
     *
     * @param  cargo  the weight of the cargo added
     */

    public void addCargo(Cargo c) {
        cargos.add(c);
    }

    /**
     * A method that add a cargo to the shipment
     *
     * @param  cargo  the weight of the cargo added
     */
    public int totalWeight() {
        int tWeight = 0;
        for (Cargo c: cargos) tWeight+=c.getWeight();
        return tWeight;
    }

}
