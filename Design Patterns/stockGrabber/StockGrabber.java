package stockGrabber;

import java.util.ArrayList;

/**
 * Created by jit_biswas on 11/22/2016.
 */
public class StockGrabber implements Subject {
    private String data;
    private ArrayList<Observer> observers;

    public StockGrabber () {
        observers = new ArrayList<Observer>();
    }

    public void stockUpdate (String value) {
        this.data=value;
        System.out.println("In stockUpdate. value = " + value);

        notifyObservers();
    }

    public void notifyObservers () {
        for (Observer O:observers) {
            O.update(this.data);
            System.out.println("Finished updating one observer.");
        }
    }

    @Override
    public void register (Observer O) {
        observers.add(O);
    }

    @Override
    public void unregister (Observer O) {
        observers.remove(O);
    }
}
