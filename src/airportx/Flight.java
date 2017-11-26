/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author AVA
 */
public class Flight {
    
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
        this(00000,"00-000","NONE","NONE","NONE","00:00","00:00", null ,000,"NONE");
    }

    public Flight(int flightId, String carrier, String dest, String source, String depart) {
        this.flightId = flightId;
        this.carrier = carrier;
        this.dest = dest;
        this.source = source;
        this.depart = depart;
    }

    public Flight(int flightId, String planeId, String carrier, String dest, String source, String depart, String arriv, ArrayList<Person> onBoard,int gate, String status) {
        this.flightId = flightId;
        this.planeId = planeId;
        this.carrier = carrier;
        this.dest = dest;
        this.source = source;
        this.depart = depart;
        this.arriv = arriv;
        this.onBoard = onBoard;
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
    
}
