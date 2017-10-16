/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author AVA
 */
public class DataGen {
    
    private static Random r = new Random();
    private static String[] statuses = {"Boarding","Left","On Air","Crashed"}; 
    
    public static Flight flight(ArrayList<Airport> airports, ArrayList<Flight> allFlights){
        int flightId;
        boolean flag = false;
        do{
            flightId = r.nextInt(89999)+10000;
            for (Flight f : allFlights) {
                if(f.getFlightId()==flightId){
                    flag=true;
                    break;
                }    
            }
            
        } while(flag);
            
        String planeId = ""+(char)(r.nextInt(26) + 'A')+(char)(r.nextInt(26) + 'A')+"-"+r.nextInt(9)+r.nextInt(9)+r.nextInt(9);
        String carrier = ""+(char)(r.nextInt(26) + 'A')+(char)(r.nextInt(26) + 'A')+(char)(r.nextInt(26) + 'A');
        Collections.shuffle(airports);
        String dest = airports.get(0).getCode();        
        String source = airports.get(1).getCode();
        String depart = ""+r.nextInt(23)+":"+r.nextInt(59);
        String arriv = ""+r.nextInt(24)+":"+r.nextInt(59);
        int gate = r.nextInt(899)+100;
        String status = statuses[r.nextInt(statuses.length)];
    
        return new Flight( flightId,  planeId,  carrier,  dest,  source,  depart,  arriv,  null, gate,  status);
    }
    
    
    
    
    
}
