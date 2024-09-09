public interface Car {
    void Book();
}

class sedan implements Car {
    public void Book(){
        System.out.println("Youe sedan car is here");
    }
}

class Suv implements Car {
    public void Book(){
        System.out.println("Your Suv car is here");
    }
}
