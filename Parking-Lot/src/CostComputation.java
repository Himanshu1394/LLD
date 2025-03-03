public class CostComputation {

    public int priceCal(Ticket T, int exitTime){
        int price = 0;

        if(T.vehicle.type.equals(vehicleType.Four)){
            price = (T.entryTime - exitTime)*50;
        }

        else if(T.vehicle.type.equals(vehicleType.Two)){
            price = (T.entryTime - exitTime)*30;
        }

        return price;
    }
}
