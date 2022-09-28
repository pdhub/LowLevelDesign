package linkedIn.code.puzzles;

/**
 * Created by PDeb on 11/1/2017.
 */
public class TowerOfHanoi {

    public void move(int numOfDisks, int source, int auxillary, int dest)
    {
        if(numOfDisks > 0) {
            move(numOfDisks - 1, source, dest, auxillary);
            System.out.println("Moved disk from " + source + " to " + auxillary);
            move(numOfDisks - 1, auxillary, source, dest);
        }
    }

    public static void main(String[] args) {
        int numdisks = 3;
        new TowerOfHanoi().move(numdisks, 1, 2, 3);
    }
}
