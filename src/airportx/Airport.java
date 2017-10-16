/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportx;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author AVA
 */
public class Airport {

    private String code;

    Airport(String code) {
        this.code = code;
    }  

    public String getCode() {
        return code;
    }

    public ArrayList<Flight> outgoing(ArrayList<Flight> flights) {
        ArrayList<Flight> result = new ArrayList<Flight>();
        for (int i = 0; i < flights.size(); i++) {

            //flights.get(i).getSource()==this.code;
            if (Objects.equals(flights.get(i).getSource(), this.getCode())) {
                result.add(flights.get(i));
            }

        }

        return result;
    }

    public ArrayList<Flight> incoming(ArrayList<Flight> flights) {
        ArrayList<Flight> result = new ArrayList<Flight>();
        for (int i = 0; i < flights.size(); i++) {

            //flights.get(i).getSource()==this.code;
            
            if (Objects.equals(flights.get(i).getDest(), this.getCode())) {
                result.add(flights.get(i));
            }
        }

        return result;
    }

}
