/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;

import java.util.ArrayList;

/**
 *
 * @author AVA
 */
public class Flight implements Comparable<Flight>{
    
    private int flightId;
    private String planeId;
    private String carrier;
    private String dest;
    private String source;
    private String depart;
    private String arriv;
    private ArrayList<Person> onBoard;
    private int gate;
    private String status;

    public Flight() {
        this(00000,"00-000","NONE","NONE","NONE","00:00","00:00" ,000,"NONE");
    }

    public Flight(int flightId, String carrier, String dest, String source, String depart) {
        this.flightId = flightId;
        this.carrier = carrier;
        this.dest = dest;
        this.source = source;
        this.depart = depart;
        getonBoard();
    }

    public Flight(int flightId, String planeId, String carrier, String dest, String source, String depart, String arriv,int gate, String status) {
        this.flightId = flightId;
        this.planeId = planeId;
        this.carrier = carrier;
        this.dest = dest;
        this.source = source;
        this.depart = depart;
        this.arriv = arriv;
       this.onBoard = getonBoard();
        this.gate = gate;
        this.status = status;
        
    }

    public int getFlightId() {
        return flightId;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getDest() {
        return dest;
    }

    public String getSource() {
        return source;
    }

    public String getDepart() {
        return depart;
    }

    public String getArriv() {
        return arriv;
    }

    public ArrayList<Person> getOnBoard() {
        return onBoard;
    }

    public int getGate() {
        return gate;
    }    
    
    public void setGate(int gate){
        this.gate = gate;
    }    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    @Override
    public int compareTo(Flight o) {
        return this.flightId - o.flightId;
          
    }
    
    private ArrayList<Person> getonBoard(){
        ArrayList<Person> temp = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
          //  System.out.println("i = "+i);
            temp.add(DataGen.randomPassenger(temp));
        }
        
        temp.add(DataGen.randomPlaneCrew(temp).setJob("Pilot"));
        temp.add(DataGen.randomPlaneCrew(temp).setJob("First Officer"));
        temp.add(DataGen.randomPlaneCrew(temp).setJob("Flight Attendant"));
        temp.add(DataGen.randomPlaneCrew(temp).setJob("Flight Attendant"));
        temp.add(DataGen.randomPlaneCrew(temp).setJob("Flight Attendant"));
        return temp;
        
    }
    
    
}
