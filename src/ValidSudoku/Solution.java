package ValidSudoku;

import java.util.HashSet;

class Solution {
    /**
     * @param board: the board
     @return: wether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();
            HashSet<Character> sqr = new HashSet<Character>();

            for(int j = 0; j < 9; j++){
                if(row.contains(board[i][j]))
                    return false;
                if(board[i][j] != '.')
                    row.add(board[i][j]);

                if(col.contains(board[j][i]))
                    return false;
                if(board[j][i] != '.')
                    col.add(board[j][i]);

                if(sqr.contains(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]))
                    return false;
                if(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.')
                    sqr.add(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]);
            }
        }

        return true;
    }
}
