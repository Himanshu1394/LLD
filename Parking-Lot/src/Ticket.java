public class Ticket {

    int entryTime;
    Vehicle vehicle;
    ParkingSpot spot;

    Ticket(int entryTime, Vehicle v){
        setEntryTime(entryTime);
        setVehicle(v);
    }

    public void getTicket(Vehicle v){
        System.out.println("Ticket generated");

    }

    public int getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
