
package airportx;


public class PlaneCrew extends Person{

    private String job; 
    
    public PlaneCrew(int id, String name, String surname, String from, String job) {
        super(id, name, surname, from);
        this.job = job;
    }

    
    public static void main(String[] args) {
        
        PlaneCrew test = new PlaneCrew(123456,"onur","sinansiker","kurdistan","whore");
        System.out.println(test.getID());
        
        
    }

    /*@Override
    public int getID() {
        
        
        if(job.equalsIgnoreCase("pilot"))
            return id+999000000;
        
    }*/

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    
    
    
}
