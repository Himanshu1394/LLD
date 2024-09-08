//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Vehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive();
        sportsVehicle.enginePower();

        Vehicle offRoadVehicle = new OffRoadVehicle();
        offRoadVehicle.drive();
        offRoadVehicle.enginePower();

        Vehicle normalVehicle = new NormalVehicle();
        normalVehicle.drive();
        normalVehicle.enginePower();




        }
    }
