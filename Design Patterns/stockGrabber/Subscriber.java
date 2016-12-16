package stockGrabber;

/**
 * Created by jit_biswas on 11/22/2016.
 */
public class Subscriber implements Observer {

    private String message; // received message
    private Subject subject;

    public Subscriber(Subject subject){
        System.out.println("Registering Subscriber: ");
        this.subject = subject;
        // register itself to the subject
        this.subject.register(this);
    }

    @Override
    public void update(String msg) {
        // get update from Subject
        this.message  = msg;
        // do something according to the update

    }
}

