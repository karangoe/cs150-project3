
/**
 * Write a description of class ExperimentController here.
 *
 * @author (Elene Karangozishvili & Trang Le)
 * @version (Dec 02, 2018)
 */

import java.util.*;
import java.io.*;
public class ExperimentController
{

    private ArrayList<Warehouse> warehouse;
    private City center;
    Graph g;
    Truck truck;

    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController() {
        warehouse = new ArrayList<Warehouse>();
        g = new Graph();
    }

    public static void main(String[] args){
        ExperimentController exp = new ExperimentController();
        exp.run();
    }

    public void run(){
        readInput();
        runDijkstra();
        sortDistances();        
        process();
        writeOutput();
    }

    /**
     * An method that reads the input files and
     * processes the contents of the input files to
     * create the Graph
     * 
     */
    public void readInput(){
        //Read the roads and create vertices (cities) and edges (roads)
        try{
            Scanner sc = new Scanner(new File("roads_large.txt"));
            String line = sc.nextLine();
            int numOfRoads = Integer.parseInt(line);
            for(int i=0;i<numOfRoads;i++){
                line = sc.nextLine();
                String[] arr = line.split(" ");
                String city1 = arr[0];
                String city2 = arr[1];
                int dist = Integer.parseInt(arr[2]);
                g.addEdge(city1, city2, dist);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        //Read the center and sets up the center
        try{
            Scanner sc = new Scanner(new File("center_large.txt"));
            String c = sc.nextLine();
            //Link the city to a coy warehouse with no cargos
            Warehouse wh = new Warehouse(c, null, g);
            
            wh.makeCenter();
            
            warehouse.add(wh);
            
            center = g.getCity(c);
            center.setWarehouse(wh);
        }
        catch(Exception e){
            System.out.println(e);
        }

        //Read the warehouses and set up warehouses
        try{
            Scanner sc = new Scanner(new File("warehouses_large.txt"));
            int numOfWarehouses = Integer.parseInt(sc.nextLine()); //Read number of warehouses from the first line
            for(int i=0;i<numOfWarehouses;i++){
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                //Reads the weights of the cargos
                ArrayList<Cargo> cargos = new ArrayList<Cargo>();
                for(int j=1;j<arr.length;j++){
                    Cargo c = new Cargo(j-1, Integer.parseInt(arr[j]));
                    cargos.add(c);
                }
                //Create a warehouse with each list of cargos
                Warehouse wh = new Warehouse(arr[0], cargos, g);
                (g.getCity(arr[0])).setWarehouse(wh); //Setting the warehouse into the cities
                warehouse.add(wh);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * A method that runs the Dijkstra algorithm
     * on the Graph
     */
    private void runDijkstra() {
        for(Warehouse w: warehouse){
            g.dijkstra(w.city);
        }
    }

    /**
     * A method that sorts other warehouses by shortest path then by name
     */
    private void sortDistances() {
        for (Warehouse wh:warehouse) {
            Collections.sort(wh.distances);
        }
    }

    private void process(){
        truck = new Truck(center);
        Trip trip = new Trip();
        while(true){
            boolean changesLocation = false;
            //System.out.println(truck.getLocation());
            Warehouse wh = truck.getLocation().getWarehouse(); 
            for(int i=0;i<wh.distances.size();i++){
                Warehouse possibleWH = wh.distances.get(i).wh;
                if(possibleWH.isEmpty()) continue;
                if(possibleWH.cargos.peek().getWeight()>truck.weightLeft) continue;
                Shipment s = new Shipment(possibleWH, wh.distances.get(i).shortestPath);
                while(!possibleWH.cargos.isEmpty() && possibleWH.cargos.peek().getWeight()<=truck.weightLeft){
                    truck.weightLeft = truck.weightLeft - possibleWH.cargos.peek().getWeight();
                    s.addCargo(possibleWH.cargos.poll());
                }
                trip.addShipment(s);
                truck.setLocation(possibleWH.city);
                changesLocation = true;
                break;
            }
            if(!changesLocation){
                if(truck.getLocation().getName().compareTo(center.getName())==0) break;
                for(int i=0; i <truck.getLocation().getWarehouse().distances.size();i++){
                    if((truck.getLocation().getWarehouse().distances.get(i).wh).city.getName().compareTo(center.getName())==0){
                        trip.setWayBack(truck.getLocation().getWarehouse().distances.get(i).shortestPath);
                        truck.setLocation(center);
                        truck.weightLeft=500;
                        truck.addTrip(trip);
                        trip = new Trip();
                    }
                }
            }
        }
    }

    public void writeOutput(){
        try{
            PrintWriter printWriter = new PrintWriter(new File("output_large.txt"));
            int totalDistanceTraveled = 0;
            for(int i=0;i<truck.getNumOfTrips();i++){
                Trip trip = truck.getTrips().get(i);
                printWriter.println("Truck "+ (i+1) +":");
                for(int j=0;j<trip.shipment.size();j++) {
                    Shipment shipment = trip.shipment.get(j);
                    printWriter.print("Deliver to warehouse "+ shipment.wh.city.getName()+" total weight: "+shipment.totalWeight()+" ([");
                    for(int k=0;k<shipment.cargos.size();k++){
                        Cargo cargo = shipment.cargos.get(k);
                        printWriter.print(shipment.wh.city.getName()+"("+cargo.num+"): "+ cargo.getWeight());
                        if(k!=shipment.cargos.size()-1) printWriter.print(", ");
                    }
                    printWriter.println("]) dist: "+shipment.traveled);
                }
                printWriter.println("Distance traveled "+trip.totalDistance());
                totalDistanceTraveled +=trip.totalDistance();
            }
            printWriter.println("Total distance traveled: " + totalDistanceTraveled);
            printWriter.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
