/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;

/**
 *
 * @author AVA
 */
public class Passenger extends Person{

    private String ticketNo;
    public Passenger(int id, String name, String surname, String from,String TicketNo) {
        super(id, name, surname, from);
        this.ticketNo = TicketNo;
        
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Passenger\n" + "\nTicket No : " + ticketNo + super.toString();
    }
    
    
    
    
    
}
