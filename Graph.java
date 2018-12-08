/**
 * Graph is the "map" of all cities (vertices) and roads (edges) in Coffeeland.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */

import java.util.*;
import java.io.*;

public class Graph {

    Map<String, City> vertexMap = new HashMap<String, City>(); 

    /**
     * A method that adds an undirected edge
     *
     * @param  start  name of the starting vertex
     * @param  end    name of the destination vertex
     * @param  weight distance between the vertices 
     */
    public void addEdge(String start, String end, int w) {
        City u = getCity(start);
        City v = getCity(end);
        u.nbs.add(new Road(u, v, w));
        v.nbs.add(new Road(v, u, w));
    }

    /**
     * A method that retrieves a city associated with a name
     *
     * @param  name  name of the city
     * @return the city with the name
     */
    public City getCity(String name) {
        City v = vertexMap.get(name);
        if (v == null) {
            v = new City(name);
            vertexMap.put(name, v);
        }
        return v;
    }

    /**
     * Dijkstra algorithm
     *
     */
    public void dijkstra(City start)
    {
        reset(start);
        PriorityQueue<City> q = new PriorityQueue<City>();
        q.add(start);
        start.dist = 0;
        while(!q.isEmpty()){
            City u = q.poll();
            if (u.visited) continue;
            if(u.getName().compareTo(start.getName())!=0 && u.isWarehouse) 
                start.getWarehouse().addOtherDistances(u.getWarehouse(), u.dist);
            u.visited = true;
            for(int i=0;i<u.nbs.size();i++){
                City v = u.nbs.get(i).v;
                if (!v.visited) {
                    if (v.dist > u.dist + u.nbs.get(i).w){
                        q.remove(v);
                        v.dist = u.dist+u.nbs.get(i).w;
                        q.add(v);
                        v.prev = u;
                    }
                }
            }
        }
    }

    //reset helper for Dijkstra
    private void reset(City start){
        Deque<City> q = new ArrayDeque<City>();
        q.add(start);
        start.dist = Integer.MAX_VALUE;
        start.visited = false;
        start.prev = null;

        while (!q.isEmpty()) {
            City u = q.poll();
            for (Road e: u.nbs) {
                City v = e.v;
                if(v.dist!=Integer.MAX_VALUE){
                    v.dist = Integer.MAX_VALUE;
                    v.visited = false;
                    v.prev = null;
                    q.add(v);
                }
            }
        }
    }
}

