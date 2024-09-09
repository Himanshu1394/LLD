//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
abstract class BasePizza{
    abstract int cost();
}

class Margherita extends BasePizza{
    public int cost(){
        return 100;
    }
}

class VeggieDelite extends BasePizza{

    public int cost(){
        return 120;
    }
}

class PeppyPaneer extends BasePizza{
    public int cost() {
        return 150;
    }
}

abstract class Topping extends BasePizza{
    abstract int cost();
}

class ExtraCheese extends Topping{

    BasePizza pizza;

    ExtraCheese(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        return pizza.cost() + 20;
    }
}

class ExtraMushroom extends Topping{

    BasePizza pizza;

    ExtraMushroom(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        return pizza.cost() + 30;
    }
}

class ExtraOlives extends Topping{

    BasePizza pizza;

    ExtraOlives(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        return pizza.cost() + 25;
    }
}
public class Main {
    public static void main(String[] args) {

        BasePizza myPizza = new ExtraOlives(new ExtraMushroom(new ExtraCheese(new Margherita())));
        BasePizza myPizza2 = new ExtraMushroom(new ExtraOlives(new VeggieDelite()));
        System.out.println(myPizza.cost());
        System.out.println(myPizza2.cost());
    }
}