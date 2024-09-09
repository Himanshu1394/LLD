import Observable.IphoneObservable;
import Observable.StockObservable;
import Observer.EmailAlertObserver;
import Observer.ObserverInterface;
import Observer.PhoneAlertObserver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StockObservable iphone = new IphoneObservable();
        ObserverInterface observer1 = new EmailAlertObserver("xyz@gmail.com", iphone);
        ObserverInterface observer2 = new EmailAlertObserver("xyz@gmail.com", iphone);
        ObserverInterface observer3 = new PhoneAlertObserver(5878769, iphone);
        iphone.add(observer1);
        iphone.add(observer2);
        iphone.add(observer3);
        iphone.setStockCount(100);
    }
}