public class CarFactory {

    public Car create(String name){

        if(name.equals("sedan"))
            return new sedan();
        else if(name.equals("Suv")){
            return new Suv();
        }

        return null;
    }
}
