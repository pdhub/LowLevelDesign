package solution4;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class TheatreSitting {
    public static void main(String[] args) {

        TheatreSitting theatreSitting = new TheatreSitting();

        Integer input[] = {1,0,0,0,0,0,1,0,0};
        List<Integer> l1 = Arrays.asList(input);
        Assert.assertTrue(theatreSitting.canSeatPeople(l1, 3));
        Assert.assertFalse(theatreSitting.canSeatPeople(l1, 4));

        Integer input2 [] = {1,0,0,1,0,0,1,0,0};
        List<Integer> l2 = Arrays.asList(input2);
        Assert.assertTrue(theatreSitting.canSeatPeople(l2, 1));
        Assert.assertFalse(theatreSitting.canSeatPeople(l2, 2));

        Integer input3 [] = {0};
        List<Integer> l3 = Arrays.asList(input3);
        Assert.assertTrue(theatreSitting.canSeatPeople(l3, 1));
        Assert.assertFalse(theatreSitting.canSeatPeople(l3, 2));

        Integer input4[] = {1,0,0,1,0,0,0,0,0,0};
        List<Integer> l4 = Arrays.asList(input4);
        Assert.assertTrue(theatreSitting.canSeatPeople(l4, 3));
        Assert.assertFalse(theatreSitting.canSeatPeople(l4, 4));
    }

    public boolean canSeatPeople(List<Integer> flowerbed, int n) {
        int count = 0;
        for(int i=0; i < flowerbed.size() && count < n; i++){
            if(flowerbed.get(i) == 0){
                int next = (i==flowerbed.size() - 1)?0:flowerbed.get(i+1);
                int prev = (i==0)?0:flowerbed.get(i-1);
                if(next == prev && next == 0){
                    count++;
                    i++;
                }
            }
        }
        return count==n;
    }

}
