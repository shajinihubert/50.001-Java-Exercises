package Observer;
import java.util.ArrayList;

/**
 * Created by jit_biswas on 11/29/2016.
 */
public class Topic implements Subject {
    private String message;  // the status
    private ArrayList<Observer> observers;

    public Topic (){
        observers = new ArrayList<Observer>();
    }
    public void Attach(Observer o) {observers.add(o);}
    public void Detach(Observer o) {observers.remove(o);}

    public void postMessage(String msg) {
        this.message = msg;
        this.NotifyObservers();
    }

    private void NotifyObservers() {
        for (Observer o: observers)
            o.update(this.message);
    }
// other features particular to Topic
}

