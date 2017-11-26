/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;


public class Pilot extends PlaneCrew{

    private int licenceID;
    
    public Pilot(int id, String name, String surname, String from) {
        super(id, name, surname, from,"Pilot");
    }

    @Override
    public int getID() {
        return licenceID;
    }
    
    
    
    
}
