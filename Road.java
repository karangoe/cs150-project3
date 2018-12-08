/**
 * Road is equivalent to an Edge in Graph.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */

public class Road {
    City u, v; //Two cities connected by the road
    int w; //Length of the road
    
    public Road(City u, City v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }
}