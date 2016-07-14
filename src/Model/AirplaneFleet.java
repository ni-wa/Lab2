/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AirplaneFleet {

    private List<Airplane> airPlaneList = new ArrayList<>();

    public Airplane getAirplaneByName(String name) {
        for (Airplane airplane : getAirPlaneList()) {
            if (airplane.getName().equals(name)) {
                return airplane;
            }
        }
        return null;
    }

    public Airplane getAirplaneById(int id) {
        for (Airplane airplane : getAirPlaneList()) {
            if (airplane.getAirplaneId() == id) {
                return airplane;

            }
        }
        // plane not found
        return null;
    }

    public void removeAirplane(Airplane airplaneToRemove) {
        getAirPlaneList().remove(airplaneToRemove);
    }
    
    public void addAirplaneToFleet(Airplane airplaneToAdd){
        getAirPlaneList().add(airplaneToAdd);
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (Airplane airplane : getAirPlaneList()) {
            sb.append(airplane.toString());
        }
        return sb.toString();
    }

    /**
     * @return the airPlaneList
     */
    public List<Airplane> getAirPlaneList() {
        return airPlaneList;
    }
    
}
