public class SportsVehicle extends Vehicle{

    SportsVehicle(){
        super(new SportsDriveCapability(), new SportsEngine());
    }
}
