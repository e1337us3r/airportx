/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author AVA
 */
public class DataGen {

    private static Random r = new Random();
    private static String[] statuses = {"Boarding", "Departed", "On Air", "Crashed","Arrived"};
    private static String[] names = {"Josephina", "Joanna", "Rome","Sallie" ,"Biddy" ,"Sauvage","Kaleigh", "Niles", "Wallis","Rosaleen", "Bret", "Whitaker","Malcom", "Zara", "Peyton","Ann", "Jaylen", "Saylor","Xzavier", "Kaleigh", "Ewart"};
    private static String[] countries = {"India","Barbados","Rwanda","Jersey","France","England","Turkey","USA","Canada","Findland","Italy","China","Japan","Senegal","Brasil","Mexico"};
    public static Flight randomFlight(ArrayList<Airport> airports, ArrayList<Flight> allFlights) {
        int flightId;
        boolean flag = false;
        do {
            flightId = r.nextInt(89999) + 10000;
            for (Flight f : allFlights) {
                if (f.getFlightId() == flightId) {
                    flag = true;
                    break;
                }
            }

        } while (flag);

        String planeId = "" + (char) (r.nextInt(26) + 'A') + (char) (r.nextInt(26) + 'A') + "-" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9);
        String carrier = "" + (char) (r.nextInt(26) + 'A') + (char) (r.nextInt(26) + 'A') + (char) (r.nextInt(26) + 'A');
        Collections.shuffle(airports);
        String dest = airports.get(0).getCode();
        String source = airports.get(1).getCode();
        String depart = randomTime();
        String arriv = randomTime();
        int gate = r.nextInt(899) + 100;
        String status = statuses[r.nextInt(statuses.length)];

        return new Flight(flightId, planeId, carrier, dest, source, depart, arriv, null, gate, status);
    }

    public static Person randomPerson(ArrayList<Person> IDlist) {
        
        int id = randomID(IDlist);         
        String name = names[r.nextInt(names.length)];
        String surname= names[r.nextInt(names.length)];
        String bday = randomBday();    
        String from = countries[r.nextInt(countries.length)];
        
        return new Passenger(id, name, surname, from);

    }

    public static String randomTime() {

        int hour = r.nextInt(23);
        int min = r.nextInt(59);
        String h = (hour < 10) ? "0" + hour : String.valueOf(hour);
        String m = (min < 10) ? "0" + min : String.valueOf(min);
        return h + ":" + m;
    }

    public static String randomBday() {

        Random r = new Random();

        int d = r.nextInt(29) + 1;
        String sd = (d < 10) ? "0" + d : String.valueOf(d);
        int m = r.nextInt(11) + 1;
        String sm = (m < 10) ? "0" + m : String.valueOf(m);
        int y = r.nextInt(100) + 1900;
        return "" + sd + "." + sm + "." + y;

    }

    public static int randomID(ArrayList<Person> IDlist) {

        int id;
        do {
            id = r.nextInt(899999999) + 100000000;
        } while (Person.indexOf(IDlist, id) == -1);
        return id;
    }

}
