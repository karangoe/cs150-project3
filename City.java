import java.util.*;

class City implements Comparable<City> {
    String name;
    List<Road> nbs = new ArrayList<Road>();
    int dist = Integer.MAX_VALUE;
    boolean visited = false;
    boolean isWarehouse = false;
    private Warehouse warehouse = null;
    City prev;
    
    public City(String n) {
      name = n;
    }
    
    @Override
    public int compareTo(City v) {
      return dist - v.dist;
    }
    
    public Warehouse getWarehouse(){
        return this.warehouse;
    }
    
    public void setWarehouse(Warehouse wh){
        this.warehouse = wh;
        this.isWarehouse = true;
    }
  }