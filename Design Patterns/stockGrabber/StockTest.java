package stockGrabber;
/**
 * Created by jit_biswas on 11/22/2016.
 */
public class StockTest {
        public static void main(String[] args) {
            System.out.println ("In StockTest");
            StockGrabber IBM = new StockGrabber();
            Subscriber scott = new Subscriber(IBM);
            Subscriber jim = new Subscriber(IBM);
            IBM.stockUpdate("IBM going up by $0.05");
//
            Subscriber jim2 = new Subscriber(IBM);
            IBM.stockUpdate("IBM is going down by $0.03");
        }
}
