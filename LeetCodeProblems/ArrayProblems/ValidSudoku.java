import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

formula for sub matrix -  (i / 3) * 3 + j / 3
     */
    public static void main(String args[]) {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        int[][] intBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    intBoard[i][j] = Character.getNumericValue(board[i][j]);
                } else {
                    intBoard[i][j] = 0; // or any value to represent empty cells
                }
            }
        }
        boolean isValidSudoku = sudokuValid(intBoard);
        System.out.print(isValidSudoku);
    }

    private static boolean sudokuValid(int[][] board) {

        // Arrays of sets to track seen numbers in rows,
        // columns, and subMatrices
        Set<Integer>[] rowSet = new HashSet[9];
        Set<Integer>[] colSet = new HashSet[9];
        Set<Integer>[] subMatSet = new HashSet[9];


        // Initialize the sets
        for(int i = 0;i<9 ;i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            subMatSet[i] = new HashSet<>();
        }

        for(int i = 0 ;i< 9 ;i++){
            for(int j = 0 ;j< 9 ;j++){
                int val = board[i][j];

                if(val == 0) continue;

                if(rowSet[i].contains(val)) return false;
                rowSet[i].add(val);

                if(colSet[j].contains(val)) return false;
                colSet[j].add(val);

                int idx = (i / 3) * 3 + j / 3;
                if(subMatSet[idx].contains(val)) return false;
                subMatSet[idx].add(val);
            }
        }

        return true;
    }
}
