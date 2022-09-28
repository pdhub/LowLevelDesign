package linkedIn.code.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TimeToRotOranges {
    static int rotOranges(int arr[][]){
        Queue<Ele> queue = new LinkedList<Ele>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2)
                    ((LinkedList<Ele>) queue).add(new Ele(i, j, arr[i][j]));
            }
        }
        //Add a delimiter
        ((LinkedList<Ele>) queue).add(new Ele(-1, -1, -1));
        while (!queue.isEmpty()){

            boolean flag = false;
            while (!delim(queue.peek())){
                Ele temp = queue.peek();
                //Repeat on all 4 directions
//                if(isValidCell(temp.x+1, temp.y)
//                        && arr[temp.x+1][temp.y] == 1){
//
//                    if (!flag){
//                        time++;
//                        flag = true;
//                    }
//
//                    arr[temp.x+1][temp.y] = 2;
//                    ((LinkedList<Ele>) queue).add(new Ele(temp.x+1, temp.y, arr[temp.x+1][temp.y]));
//                }
                queue.remove();//
            }
            queue.remove();//Removing delimiter
        }
        return 0;
    }

    private static boolean delim(Ele peek) {
        return peek.x == -1 &&  peek.y == -1 &&
                peek.val == -1;
    }

    static class Ele{
        int x;
        int y;
        int val;

        public Ele(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
