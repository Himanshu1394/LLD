package Observable;

import Observer.ObserverInterface;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable{

    public List<ObserverInterface> ObserverList = new ArrayList<>();
    int stock = 0;

    public void add(ObserverInterface observer){
        ObserverList.add(observer);
    }

    @Override
    public void remove(ObserverInterface observer) {
        ObserverList.remove(observer);
    }

    public void notifyObserver(){

        for(ObserverInterface observer : ObserverList){
            observer.update();
        }
    }

    public void setStockCount(int stockAdded){
        if(stock == 0)
            notifyObserver();
        stock += stockAdded;

    }

    public int getStockCount(){
        return stock;
    }

}
