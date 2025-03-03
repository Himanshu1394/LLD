package org.example;

public class ParkingSpot {
    boolean status;
    ParkingType type;

    ParkingSpot(ParkingType type){
        this.type = type;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

}
