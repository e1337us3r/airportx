/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;


public  class PlaneCrew extends Person{

    private String job; 
    
    public PlaneCrew(int id, String name, String surname, String from, String job) {
        super(id, name, surname, from);
        this.job = job;
    }

    @Override
    public int getID() {
        return this.id;
    }

    
    
    
    
}
