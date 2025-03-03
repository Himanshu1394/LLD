public class Vehicle {
    int vehicleNumber;
    vehicleType type;

    Vehicle(vehicleType v, int number){

        this.type = v;
        this.vehicleNumber = number;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public String toString() {
        return "" +
                "" + type +
                '}';
    }
}
