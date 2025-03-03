public class EntryGate {

    int id;
    ParkingLotManager manager;
    Vehicle vehicle;
    ParkingManagerFactory factory;
    Ticket ticket;

    public EntryGate(int id){
        this.id = id;
    }

    public void getParkingManager(Vehicle v){
        manager = factory.getParkingManager(v);
    }

    public int getParkingSpace(Vehicle v){
        manager = factory.getParkingManager(v);
        return manager.getParkingSpace();
    }

    public void generateTicket(int time, Vehicle v){
        ticket = new Ticket(time, v);
        manager = factory.getParkingManager(v);
        manager.parkVehicle();
        System.out.println("Ticket generated for vehicle"+v.vehicleNumber);

    }
}
