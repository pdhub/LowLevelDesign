package linkedIn.code.backtracking;

/**
 * Created by PDeb on 11/1/2017.
 */
public class NQueensProblem {

    public boolean isQueenSafeHere(char board[][], int queenRow, int queenCol){
        for (int i = 0; i < queenRow; i++) {
            if(board[i][queenCol] == 'Q')
                return false;
        }

        for (int i = queenRow, j = queenCol; i >=0 && j>=0  ; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        for (int i = queenRow, j = queenCol; i >= 0 && j < 8  ; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public void nQueen(char board[][], int row, int col)
    {
        if(col ==0 && row==8)
        {
            //print the matrix
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println("Solution ends here");
        }

        for (int i = 0; i < 8; i++) {
            if(isQueenSafeHere(board, row, i)){
                board[row][i] = 'Q';
                nQueen(board, row+1, 0);
                board[row][i] = '-';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[8][8];
        new NQueensProblem().nQueen(board, 0, 0);
    }

}
