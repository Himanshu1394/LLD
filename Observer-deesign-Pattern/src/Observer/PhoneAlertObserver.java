package Observer;

import Observable.StockObservable;

public class PhoneAlertObserver implements ObserverInterface{

    int contact;
    StockObservable observable;

    public PhoneAlertObserver(int contact, StockObservable observable){
        this.contact = contact;
        this.observable = observable;

    }

    public void update(){

        sendSms(contact, "Stock is Available");
    }

    public void sendSms(int contact, String msg){

        System.out.println(msg +" SMS sent to "+contact);
    }
}
