
package airportx;


public class PlaneCrew extends Person{

    private String job; 
    
    public PlaneCrew(int id, String name, String surname, String from) {
        super(id, name, surname, from);
    }
    public PlaneCrew(int id, String name, String surname, String from, String job) {
        super(id, name, surname, from);
        this.job = job;
    }

    @Override
    public int getID() {
        
        
        if(job.equalsIgnoreCase("pilot"))
            return id+999000000;
        else if (job.equalsIgnoreCase("first officer"))
            return id+888000000;
        else if(job.equalsIgnoreCase("filight attendant"))
            return id+777000000;
        else return id;
        
    }

    public PlaneCrew setJob(String job) {
        this.job = job;
        return this;
    }

    @Override
    public String toString() {
        return "Plane Crew\n"+"\nJob : "+this.job+super.toString();
    }
    
    
    
}
