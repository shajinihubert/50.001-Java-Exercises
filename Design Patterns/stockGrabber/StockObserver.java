package stockGrabber;

/**
 * Created by jit_biswas on 11/22/2016.
 */
public class StockObserver implements Observer {
    private String message;
    private Subject company;

    public StockObserver (Subject company) {
        this.company = company;
        this.company.register(this);
    }
    @Override
    public void update (String msg) {
        this.message = msg;
        System.out.println ("Message received: " + this.message);
    }
}
