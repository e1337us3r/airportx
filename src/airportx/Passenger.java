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

    
    public Passenger(int id, String name, String surname, String from) {
        super(id, name, surname, from);
    }

    @Override
    public int getID() {
        return this.id;
    }
    
    
}
