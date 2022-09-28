package linkedIn.code.Threading;

/**
 * Created by pdeb on 11/22/2017.
 */
public class Even implements Runnable {

    public Object sharedObject;

    public Even(Object sharedObject) {
        this.sharedObject = sharedObject;
    }

    public void run() {
        for (int i = 0; i < 10; i=i+2) {
            synchronized (sharedObject){
                System.out.print(i + " ");
                sharedObject.notify();
            }
        }
    }
}
