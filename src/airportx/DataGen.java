package airportx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DataGen {

    private static Random r = new Random();
    //Some String pools to generate sensical random data
    private static String[] statuses = {"Boarding", "Departed", "On Air", "Crashed", "Arrived"};
    private static String[] names = {"Josephina", "Joanna", "Rome", "Sallie", "Biddy", "Sauvage", "Kaleigh", "Niles", "Wallis", "Rosaleen", "Bret", "Whitaker", "Malcom", "Zara", "Peyton", "Ann", "Jaylen", "Saylor", "Xzavier", "Kaleigh", "Ewart"};
    private static String[] countries = {"India", "Barbados", "Rwanda", "Jersey", "France", "England", "Turkey", "USA", "Canada", "Findland", "Italy", "China", "Japan", "Senegal", "Brasil", "Mexico"};

    public static Flight randomFlight(ArrayList<Airport> airports, ArrayList<Flight> allFlights) {
        int flightId;

        //generate unique flight id
        do {
            flightId = r.nextInt(899999) + 100000;

        } while (SystemClass.findFlight(flightId) != null);

        String planeId = "" + (char) (r.nextInt(26) + 'A') + (char) (r.nextInt(26) + 'A') + "-" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9);
        String carrier = "" + (char) (r.nextInt(26) + 'A') + (char) (r.nextInt(26) + 'A') + (char) (r.nextInt(26) + 'A');

        //Get random airport for destination and source and make sure the are not the same
        Collections.shuffle(airports);
        String dest = airports.get(0).getCode();
        String source = airports.get(1).getCode();

        String depart = randomTime();
        String arriv = randomTime();
        int gate = r.nextInt(899) + 100;
        String status = statuses[r.nextInt(statuses.length)];

        return new Flight(flightId, planeId, carrier, dest, source, depart, arriv, gate, status);
    }

    public static Person randomPassenger(ArrayList<Person> IDlist) {
        //generate random passenger
        int id = randomID(IDlist);
        String name = names[r.nextInt(names.length)];
        String surname = names[r.nextInt(names.length)];
        String bday = randomBday();
        String from = countries[r.nextInt(countries.length)];
        String ticketNo = "" + (char) (r.nextInt(26) + 'A') + (r.nextInt(899999) + 100000) + (char) (r.nextInt(26) + 'A');

        return new Passenger(id, name, surname, from, ticketNo);

    }

    public static PlaneCrew randomPlaneCrew(ArrayList<Person> IDlist) {
        //generate random plane crew 
        int id = randomID(IDlist);
        String name = names[r.nextInt(names.length)];
        String surname = names[r.nextInt(names.length)];
        String bday = randomBday();
        String from = countries[r.nextInt(countries.length)];

        return new PlaneCrew(id, name, surname, from);

    }

    public static String randomTime() {
        //generate random time 00.00-23.59
        int hour = r.nextInt(23);
        int min = r.nextInt(59);
        //if hour,minute is single digit, prepend 0
        String h = (hour < 10) ? "0" + hour : String.valueOf(hour);
        String m = (min < 10) ? "0" + min : String.valueOf(min);
        return h + ":" + m;
    }

    public static String randomBday() {
        //generate random birth date 01.01.1900-30.12.1999
        int d = r.nextInt(29) + 1;
        //if day is single digit, prepend 0
        String sd = (d < 10) ? "0" + d : String.valueOf(d);
        int m = r.nextInt(11) + 1;
        //if month is single digit, prepend 0
        String sm = (m < 10) ? "0" + m : String.valueOf(m);
        int y = r.nextInt(100) + 1900;
        return "" + sd + "." + sm + "." + y;

    }

    public static int randomID(ArrayList<Person> IDlist) {
        //generate unique random id
        int id;
        do {
            id = r.nextInt(899999) + 100000;
        } while (Person.indexOf(IDlist, id) != -1);
        return id;
    }

}
