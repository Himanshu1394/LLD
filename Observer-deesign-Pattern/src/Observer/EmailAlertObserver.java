package Observer;

import Observable.StockObservable;

public class EmailAlertObserver implements ObserverInterface{

    String emailId;
    StockObservable observable;

    public EmailAlertObserver(String emailId, StockObservable observable){

        this.emailId = emailId;
        this.observable = observable;
    }

    public void update(){

        sendEmail(emailId, "Stock is available");
    }

    public void sendEmail(String emailId, String msg){

        System.out.println(msg+" Email sent to "+emailId);

    }
}
