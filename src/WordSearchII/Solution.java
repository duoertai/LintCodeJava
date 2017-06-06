package WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> res = new ArrayList<String>();

        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return res;

        if(words == null || words.size() == 0)
            return res;

        int m = board.length;
        int n = board[0].length;

        HashSet<String> set = new HashSet<String>();
        boolean[][] visited = new boolean[m][n];

        TrieNode root = new TrieNode();
        for(String s: words)
            add(root, s);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                helper("", i, j, board, root, set, visited);
            }
        }

        for(String s: set)
            res.add(s);

        return res;
    }

    public void helper(String str, int i, int j, char[][] board, TrieNode root, HashSet<String> set, boolean[][] visited){
        int m = board.length;
        int n = board[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return;

        str = str + board[i][j];

        TrieNode temp = root;
        for(int k = 0; k < str.length(); k++){
            char c = str.charAt(k);
            temp = temp.children[c - 'a'];

            if(temp == null)
                break;
        }

        if(temp == null)
            return;

        if(temp.str != null && !set.contains(str)){
            set.add(str);
        }

        visited[i][j] = true;
        helper(str, i + 1, j, board, root, set, visited);
        helper(str, i - 1, j, board, root, set, visited);
        helper(str, i, j - 1, board, root, set, visited);
        helper(str, i, j + 1, board, root, set, visited);
        visited[i][j] = false;
    }

    class TrieNode{
        public TrieNode[] children;
        public String str;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.str = null;
        }
    }

    public void add(TrieNode root, String s){
        if(s == null || s.length() == 0)
            return;
        TrieNode temp = root;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(temp.children[c - 'a'] == null)
                temp.children[c - 'a'] = new TrieNode();

            temp = temp.children[c - 'a'];
        }
        temp.str = s;

        return;
    }

}
