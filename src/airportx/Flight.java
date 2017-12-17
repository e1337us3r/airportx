package airportx;

import java.util.ArrayList;

public class Flight implements Comparable<Flight> {

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
        this(00000, "00-000", "NONE", "NONE", "NONE", "00:00", "00:00", 000, "NONE");
    }

    public Flight(int flightId, String carrier, String dest, String source, String depart) {
        this.flightId = flightId;
        this.carrier = carrier;
        this.dest = dest;
        this.source = source;
        this.depart = depart;
        
    }

    public Flight(int flightId, String planeId, String carrier, String dest, String source, String depart, String arriv, int gate, String status) {
        this.flightId = flightId;
        this.planeId = planeId;
        this.carrier = carrier;
        this.dest = dest;
        this.source = source;
        this.depart = depart;
        this.arriv = arriv;
        this.onBoard = fillonBoard();
        this.gate = gate;
        this.status = status;

    }

    public ArrayList<Person> getOnBoard() {
        return onBoard;
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

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
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

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setArriv(String arriv) {
        this.arriv = arriv;
    }

    private ArrayList<Person> fillonBoard() {
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

    @Override
    public int compareTo(Flight o) {
        return this.flightId - o.flightId;

    }

    @Override
    public String toString() {
        return "Flight Id : " + flightId + "\n\nPlane Id : " + planeId + "\n\nCarrier : " + carrier + "\n\nDestination : " + dest + "\n\nSource : " + source + "\n\nDeparture : " + depart + "\n\nArrival : " + arriv + "\n\nGate : " + gate + "\n\nStatus : " + status;
    }
    
}
