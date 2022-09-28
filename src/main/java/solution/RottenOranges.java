package solution;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    static int maxDayToRot[][];
    static int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static int numDaysToRot = 0;
    public static void main(String[] args) {
        int arr[][] = new int[][]{{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        Queue<int[]> rotten = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]==2){
                    rotten.add(new int[]{i, j});
                }
            }
        }

        while(!rotten.isEmpty()){
            int size = rotten.size();
            while (size-- >0){
                int[] rottenIndex = rotten.poll();
                for (int[] d : dir) {
                    int newi = rottenIndex[0] + d[0];
                    int newj = rottenIndex[1] + d[1];
                    if(newi >= 0 && newi < arr.length && newj >=0 && newj < arr[0].length){
                        if (arr[newi][newj] == 1){
                            arr[newi][newj] = 2;
                            rotten.add(new int[]{newi, newj});
                        }
                    }
                }

            }
            numDaysToRot++;
        }
        System.out.println(numDaysToRot);
    }
}

/*
arr[][] = {{2, 1, 0, 2, 1},
           {1, 0, 1, 2, 1},
           {1, 0, 0, 2, 1}};

           {{2, 2, 0, 2, 2},
           {2, 0, 2, 2, 2},
           {1, 0, 0, 2, 2}};

           {{2, 2, 0, 2, 2},
           {2, 0, 2, 2, 2},
           {2, 0, 0, 2, 2}};

no of days = 2
return -1;

2 ro
1 fo
0 empty cell
 */