package stockGrabber;

/**
 * Created by jit_biswas on 11/22/2016.
 */
public interface Subject {
    void register (Observer o);
    void unregister (Observer o);
    void stockUpdate (String S);
}
