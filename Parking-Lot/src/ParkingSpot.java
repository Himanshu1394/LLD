public class ParkingSpot {
    boolean isEmpty;
    Vehicle vehicle;

    public void parkVehicle(Vehicle vehicle){
        isEmpty = false;
    }

    public void removeVehicle(Vehicle vehicle){
        isEmpty = true;
    }

    public int price(){
        return 20;
    }



}




