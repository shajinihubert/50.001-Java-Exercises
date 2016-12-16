package Observer;

public class MyClass {
    public static void main (String[] args) {
        Topic topic50001 = new Topic();
        Subscriber scott = new Subscriber(topic50001);
        Subscriber roger = new Subscriber(topic50001);
        //note Attach takes place within constructor
        topic50001.postMessage("quiz tomorrow !!!main");

        Subscriber jit = new Subscriber(topic50001);
        topic50001.postMessage("HW due this Wed!!main");
        topic50001.Detach(jit);
        topic50001.postMessage("Great! Jit has gone!main");
    }
}
