package WordSearch;

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(word == null || word.length() == 0)
            return true;

        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j])
                    if(find(board, visited, i, j, 0, word))
                        return true;
            }
        }

        return false;
    }

    public boolean find(char[][] board, boolean[][] visited, int i, int j, int start, String word){
        if(start == word.length())
            return true;

        int m = board.length;
        int n = board[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n)
            return false;

        if(visited[i][j] || board[i][j] != word.charAt(start))
            return false;

        visited[i][j] = true;
        if(find(board, visited, i - 1, j, start + 1, word))
            return true;
        if(find(board, visited, i + 1, j, start + 1, word))
            return true;
        if(find(board, visited, i, j - 1, start + 1, word))
            return true;
        if(find(board, visited, i, j + 1, start + 1, word))
            return true;

        visited[i][j] = false;

        return false;
    }
}