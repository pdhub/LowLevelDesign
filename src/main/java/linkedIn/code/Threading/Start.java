package linkedIn.code.Threading;

/**
 * Created by pdeb on 11/22/2017.
 */
public class Start {
    public static void main(String[] args) {

        Object shared = new Object();
        new Thread(new Even(shared)).start();
        new Thread(new Odd(shared)).start();
    }
}
