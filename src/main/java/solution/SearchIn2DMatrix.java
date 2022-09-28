package solution;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,60}};
        int target = 13;
        new SearchIn2DMatrix().searchMatrix(matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int hi = (n * m) - 1;

        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
