import java.util.ArrayList;
import java.util.List;

public class FourWheelerManager extends ParkingLotManager{
    List<ParkingSpot> fourWheelerParking;

    FourWheelerManager(){
        super(new ArrayList<>());
        this.fourWheelerParking = super.parkingSpotList;
    }
}
