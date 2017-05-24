package SurroundedRegions;

public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here

        if(board == null || board.length <= 2 || board[0] == null || board[0].length <= 2)
            return;

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++)
            if(board[i][0] == 'O')
                mark(board, i, 0);
        for(int i = 0; i < m; i++)
            if(board[i][n - 1] == 'O')
                mark(board, i, n - 1);
        for(int i = 0; i < n; i++)
            if(board[0][i] == 'O')
                mark(board, 0, i);
        for(int i = 0; i < n; i++)
            if(board[m - 1][i] == 'O')
                mark(board, m - 1, i);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }

        return;
    }

    public void mark(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n)
            return;

        if(board[i][j] != 'O')
            return;

        board[i][j] = '#';
        mark(board, i - 1, j);
        mark(board, i + 1, j);
        mark(board, i, j - 1);
        mark(board, i, j + 1);

        return;
    }

}
