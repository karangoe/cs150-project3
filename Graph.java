import java.util.*;
import java.io.*;

public class Graph {

    Map<String, City> vertexMap = new HashMap<String, City>(); 

    /* add an undirected edge */
    public void addEdge(String start, String end, int w) {
        City u = getVertex(start);
        City v = getVertex(end);
        u.nbs.add(new Road(u, v, w));
        v.nbs.add(new Road(v, u, w));
    }

    // retrieve vertex associated with the given name
    public City getVertex(String name) {
        City v = vertexMap.get(name);
        //System.out.println(v+" "+name);
        if (v == null) {
            v = new City(name);
            vertexMap.put(name, v);
        }
        //System.out.println("at get vertex city: "+v+" name: "+v.name);
        return v;
    }

    public void dijkstra(City start)
    {
        reset(start);
        PriorityQueue<City> q = new PriorityQueue<City>();
        q.add(start);
        start.dist = 0;
        while(!q.isEmpty()){
            City u = q.poll();
            if (u.visited) continue;
            if(u.name.compareTo(start.name)!=0 && u.isWarehouse)
                start.getWarehouse().addOtherWarehouse(u.getWarehouse(), u.dist);
            u.visited = true;
            for(int i=0;i<u.nbs.size();i++){
                City v = u.nbs.get(i).v;
                if (!v.visited) {
                    if (v.dist > u.dist + u.nbs.get(i).w){
                        v.dist = u.dist+u.nbs.get(i).w;
                        q.add(v);
                        v.prev = u;
                    }
                }
            }
        }
    }

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

            // /* run a BFS form a given start vertex */
            // public void bfs(Vertex startVertex) {
            // Deque<Vertex> q = new ArrayDeque<Vertex>();
            // q.add(startVertex);
            // startVertex.dist = 0;

            // while (!q.isEmpty()) {
            // Vertex u = q.poll();
            // System.out.println(u.name + " " +u.dist);
            // for (Edge e: u.nbs) {
            // Vertex v = e.v;
            // if (v.dist == Integer.MAX_VALUE) {
            // q.add(v);
            // v.dist = u.dist+1;
            // }
            // }

            // }
            // }

            // /* run a DFS from a given start vertex */
            // public void dfs(Vertex startVertex) {
            // Deque<Vertex> s = new ArrayDeque<Vertex>();
            // s.push(startVertex);
            // startVertex.visited = true;
            // while (!s.isEmpty()) {
            // Vertex u = s.pop();
            // System.out.println(u.name);
            // for (Edge e: u.nbs) {
            // Vertex v = e.v;
            // if (!v.visited) {
            // s.push(v);
            // v.visited = true;
            // }
            // }
            // }
            // }

            // /* run a recursive DFS from a given vertex */
            // public void recursiveDfs(Vertex u) {
            // u.visited = true;
            // System.out.println(u.name);
            // for (Edge e: u.nbs) {
            // Vertex v = e.v;
            // if (!v.visited) recursiveDfs(v);
            // }

            // }

            // /* find the shortest path from the given start vertex */
            // public void shortestPath(Vertex startVertex) {
            // reset();
            // PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
            // q.add(startVertex);
            // startVertex.dist = 0;

            // while (!q.isEmpty()) {
            // Vertex u = q.poll();
            // if (u.visited) continue;
            // u.visited = true;
            // System.out.println(u.name + " " + u.dist + " " + ((u.prev==null)?"":u.prev.name));
            // for (Edge e: u.nbs) {
            // Vertex v = e.v;
            // if (v.dist > u.dist + e.w) {
            // v.dist = u.dist + e.w;
            // v.prev = u;
            // q.add(v);
            // }
            // }
            // }
            // }

            // /* reset the parameters of all vertices */
            // public void reset() {
            // for (Vertex v: vertexMap.values()) {
            // v.dist = Integer.MAX_VALUE;
            // v.visited = false;
            // v.prev = null;
            // }
            // }

            // public static void main(String[] args) throws IOException {
            // Scanner in = new Scanner(new FileReader("graph1.txt"));

            // Graph g = new Graph();

            // while (in.hasNextLine()) {
            // String[] line = in.nextLine().split(" ");
            // if (line.length == 3) { // weighted graph
            // int w = Integer.parseInt(line[2]);
            // g.addEdge(line[0], line[1], w);
            // } else {
            // g.addEdge(line[0], line[1], 1);
            // }
            // }

            // g.shortestPath(g.getVertex("A"));
            // }

        }

    
