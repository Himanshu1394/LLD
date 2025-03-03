import java.util.List;

public class ParkingLotManager {
    List<ParkingSpot> parkingSpotList;

    ParkingLotManager(List<ParkingSpot> psList){
        parkingSpotList = psList;
    }

    public void addParkingSpace(ParkingSpot spot){
        parkingSpotList.add(spot);
    }

    public void removeParkingSpace(ParkingSpot spot){
        parkingSpotList.remove(spot);
    }

    int getParkingSpace(){
        return parkingSpotList.size();
    }

    public void parkVehicle(Vehicle v, ParkingSpot spot){

    }

    //public Ticket generateTicket()

    public void removeVehicle(Vehicle v, ParkingSpot spot){

    }
}
