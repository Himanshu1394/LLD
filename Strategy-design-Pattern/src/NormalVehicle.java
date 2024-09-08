public class NormalVehicle extends Vehicle{

    NormalVehicle(){
        super(new NormalDriveCapability(), new NormalEngine());
    }

}
