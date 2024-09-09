package Observable;

import Observer.ObserverInterface;

public interface StockObservable {

    public void add(ObserverInterface observer);
    public void remove(ObserverInterface observer);
    public void notifyObserver();
    public void setStockCount(int stockAdded);
    public int getStockCount();

}
