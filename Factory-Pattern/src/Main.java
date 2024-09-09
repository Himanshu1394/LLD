//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CarFactory factory = new CarFactory();
        Car newcar1 = factory.create("Suv");
        Car newcar2 = factory.create("sedan");
        newcar1.Book();
        newcar2.Book();
    }
}