package Observer;
/**
 * Created by jit_biswas on 11/29/2016.
 */
public interface Subject {
    void Attach(Observer o);	  //call to attach observer
    void Detach(Observer o);      //call to detach observer
    void postMessage(String S);   //inform all registered observers when state change occurs
}

