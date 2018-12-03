
/**
 * Write a description of class ExperimentController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
public class ExperimentController
{

    private ArrayList<Warehouse> warehouse = new ArrayList<Warehouse>();
    private City center;
    Graph g = new Graph();
    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController()
    {
    }

    public static void main(){
        ExperimentController exp = new ExperimentController();
        exp.run();
    }

    public void run(){
        readInput();
        for(int i=0;i<warehouse.size();i++){
            g.dijkstra(warehouse.get(i).city);
        }
        process();
    }

    public void readInput(){
        try{
            Scanner sc = new Scanner(new File("roads.txt"));
            String line = sc.nextLine();
            //System.out.println(line);
            int numOfRoads = Integer.parseInt(line);
            //System.out.println(numOfRoads);
            for(int i=0;i<numOfRoads;i++){
                line = sc.nextLine();
                String[] arr = line.split(" ");
                String city1 = arr[0];
                String city2 = arr[1];
                int dist = Integer.parseInt(arr[2]);
                //System.out.println(city1 + " "+city2+" "+dist);
                g.addEdge(city1, city2, dist);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Scanner sc = new Scanner(new File("center.txt"));
            String c = sc.nextLine();
            Warehouse wh = new Warehouse(c, null, g);
            wh.setIsCenter(true);
            warehouse.add(wh);
            center = g.getVertex(c);
            (center).setWarehouse(wh);
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            Scanner sc = new Scanner(new File("warehouses.txt"));
            int numOfWarehouses = Integer.parseInt(sc.nextLine());
            for(int i=0;i<numOfWarehouses;i++){
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                ArrayList<Integer> cargos = new ArrayList<Integer>();
                for(int j=1;j<arr.length;j++){
                    cargos.add(Integer.parseInt(arr[j]));
                }
                Warehouse wh = new Warehouse(arr[0], cargos, g);
                (g.getVertex(arr[0])).setWarehouse(wh);
                warehouse.add(wh);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void process(){
        Truck truck = new Truck(center);

        while(true){
            //System.out.println("We're at: "+ truck.location.name);
            boolean changesLocation = false;
            Warehouse wh = truck.location.getWarehouse();            
            for(int i=0;i<wh.otherWarehouses.size();i++){
                Warehouse possibleWH = wh.otherWarehouses.get(i);
                //System.out.println("possible warehouse: "+wh.otherWarehouses.get(i).city.name+" with distance "+wh.shortestPath.get(i));
                //System.out.println(possibleWH.cargos.size());
                if(possibleWH.isEmpty()) continue;
                if(possibleWH.cargos.peek()>truck.weightLeft) continue;
                truck.distTraveled += wh.shortestPath.get(i);
                int totalWeight=0;
                //System.out.println("weight left: "+truck.weightLeft+" next cargo: "+possibleWH.cargos.peek());
                while(!possibleWH.cargos.isEmpty() && possibleWH.cargos.peek()<=truck.weightLeft){
                    //System.out.println("weight left: "+truck.weightLeft+" next cargo: "+possibleWH.cargos.peek());
                    totalWeight += possibleWH.cargos.peek();
                    truck.weightLeft = truck.weightLeft - possibleWH.cargos.poll();
                }
                truck.location = possibleWH.city;
                changesLocation = true;
                System.out.println("Deliver to warehouse "+ possibleWH.city.name+" total weight: "+totalWeight+" dist "+wh.shortestPath.get(i));
                break;
            }
            if(!changesLocation){
                if(truck.location.name.equals(center.name)) break;
                for(int i=0;i<truck.location.getWarehouse().otherWarehouses.size();i++){
                    if((truck.location.getWarehouse().otherWarehouses.get(i)).city.name.compareTo(center.name)==0){
                        truck.distTraveled -= truck.location.getWarehouse().shortestPath.get(i);
                        truck.location = center;
                        truck.weightLeft=500;
                        System.out.println("Ends of one road, total distance: ");
                    }
                }
            }
        }
    }

}
