public class ParkingManagerFactory {

    ParkingLotManager getParkingManager(Vehicle v){

        if(v.type.equals(vehicleType.Two)){
            return new TwoWheelerManager();
        }

        return new FourWheelerManager();

    }
}
