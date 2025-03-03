import java.util.ArrayList;
import java.util.List;

public class TwoWheelerManager extends ParkingLotManager{
    public List<ParkingSpot> twoWheelerList;

    public TwoWheelerManager(){
        super(new ArrayList<>());
        this.twoWheelerList = super.parkingSpotList;
    }

    public int getParking(){
        return 0;
    }

}
