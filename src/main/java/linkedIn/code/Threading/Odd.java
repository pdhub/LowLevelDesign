package linkedIn.code.Threading;

/**
 * Created by pdeb on 11/22/2017.
 */
public class Odd implements Runnable {

    public Object sharedObject;

    public Odd(Object sharedObject) {
        this.sharedObject = sharedObject;
    }

    public void run() {

        for (int i = 1; i < 10; i=i+2) {
                try {

                    synchronized (sharedObject){
                        sharedObject.wait();
                        System.out.println(i +" ");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

