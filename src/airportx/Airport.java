package airportx;

import java.util.ArrayList;
import java.util.Objects;

public class Airport {

    private String code;

    public Airport(String code) {
        this.code = code;
    }  

    public String getCode() {
        return code;
    }

    public ArrayList<Flight> outgoing(ArrayList<Flight> flights) {
        ArrayList<Flight> result = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            if (Objects.equals(flights.get(i).getSource(), this.getCode())) {
                result.add(flights.get(i));
            }
        }
        return result;
    }

    public ArrayList<Flight> incoming(ArrayList<Flight> flights) {
        ArrayList<Flight> result = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            if (Objects.equals(flights.get(i).getDest(), this.getCode())) {
                result.add(flights.get(i));
            }
        }
        return result;
    }
}
