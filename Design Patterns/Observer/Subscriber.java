package Observer;
/**
 * Created by jit_biswas on 11/29/2016.
 */
public class Subscriber implements Observer {

    private String message; // received message
    private Subject subject;

    public Subscriber(Subject subject){
        this.subject = subject;
        // register itself to the subject
        this.subject.Attach(this);
    }

    @Override
    public void update(String msg) {
        // get update from Subject
        this.message  = msg;
        System.out.println(msg);
        // do something according to the update

    }


}
