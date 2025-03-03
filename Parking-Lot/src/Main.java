//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingSpot p1 = new FourWheelerSpot();
        ParkingSpot p2 = new FourWheelerSpot();
        ParkingSpot p3 = new TwoWheelerSpot();

        EntryGate e1 = new EntryGate(1);
        ParkingManagerFactory pf = new ParkingManagerFactory();
        ParkingLotManager psFourManager = pf.getParkingManager("Four");
        ParkingLotManager psTwoManager = pf.getParkingManager("Two");

        psFourManager.addParkingSpace(p1);
        psFourManager.addParkingSpace(p2);
        //psFourManager.removeParkingSpace(p1);
        psTwoManager.addParkingSpace(p3);




        Vehicle v1 = new Vehicle(vehicleType.Four, 5623);
        System.out.println(psFourManager.getParkingSpace());
        e1.generateTicket(10, v1);

        Vehicle v2 = new Vehicle(vehicleType.Two, 1311);
        System.out.println(psTwoManager.getParkingSpace());
        e1.generateTicket(1030, v2);

    }

}