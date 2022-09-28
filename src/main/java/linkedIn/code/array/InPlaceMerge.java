package linkedIn.code.array;

/**
 * Created by pdeb on 11/15/2017.
 */
public class InPlaceMerge {
    public static void main(String[] args) {
        int a1[] = {1,4,7,8,9};
        int a2[] = {1,3,9};

        inplaceMerge(a1, a2);

        printarr(a1);
        printarr(a2);
    }

    private static void printarr(int[] a1) {
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i]+" ");
        }
    }

    private static void inplaceMerge(int[] a1, int[] a2) {
        int i = 0, j = 0;
        while(i < a1.length){
            while(a1[i]< a2[j])
                i++;
            int temp = a2[j];
            a2[j] = a1[i];
            a1[i] = temp;

            for (int k = 1; k < a2.length; k++) {
                if(a2[k-1] > a2[k]){
                    int temp2 = a2[k];
                    a2[k] = a2[k-1];
                    a2[k-1] = temp2;
                }
            }
            i++;
        }
    }
}
