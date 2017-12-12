package airportx;

import java.util.ArrayList;


public class SystemClass {
    
    public static ArrayList<Flight> flightList= new ArrayList<>();
    public static ArrayList<Airport> airportList= new ArrayList<>();
    
    
    public static boolean addFlight(Flight f){
    
        if(!flightList.contains(f)){
            flightList.add(f);
            return true;
        }
        
        return false;
    }
    
    public static boolean addAirport(Airport a){
    
        if(!airportList.contains(a)){
            airportList.add(a);
            return true;
        }
        
        return false;
    }
    
    public static boolean deleteFlight(int id){
    
        for (int i = 0; i < flightList.size(); i++) {
            if(flightList.get(i).getFlightId()==id){
                flightList.remove(i);
                return true;
            }
        }
        return false;
    }
    public static boolean deleteAirport(String code){
    
        for (int i = 0; i < flightList.size(); i++) {
            if(airportList.get(i).getCode().equals(code)){
                airportList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    
    public static ArrayList<Flight> getAllFlights(){
        return flightList;
    }
    public static ArrayList<Airport> getAllAirports(){
        return airportList;
    }
    
    public static Flight findFlight(int id){
    
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getFlightId()==id) {
                return flightList.get(i);
            }
        }
        
    return null;
    }
    
    
    
    
    
}
