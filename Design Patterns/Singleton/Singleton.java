package Singleton;

/**
 * Created by jit_biswas on 11/28/2016.
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance () {					//global access to this instance
        if (instance == null) {
            instance = new Singleton (); 						//instance created only when it is called for.
        }
        return instance;
    }

    public static void showMessage () {
        System.out.println ("In Singleton:: showmessage()");
    }
}
