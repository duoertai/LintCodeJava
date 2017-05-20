package NQueens;

import java.util.ArrayList;

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();

        helper(res, solution, n);

        for(int i = 0; i < res.size(); i++){
            ArrayList<Integer> temp = res.get(i);
            ArrayList<String> str = new ArrayList<String>();
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < n; j++){
                int position = temp.get(j);

                for(int k = 0; k < n; k++){
                    if(k == position)
                        s.append('Q');
                    else
                        s.append('.');
                }
                str.add(s.toString());
                s = new StringBuilder();
            }

            result.add(str);
        }

        return result;
    }

    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> solution, int n){
        if(solution.size() == n){
            res.add(new ArrayList<Integer>(solution));
            return;
        }

        for(int i = 0; i < n; i++){
            solution.add(i);
            if(valid(solution))
                helper(res, solution, n);
            solution.remove(solution.size() - 1);
        }

        return;
    }

    public boolean valid(ArrayList<Integer> solution){
        if(solution.size() <= 1)
            return true;

        for(int i = 0; i < solution.size(); i++){
            for(int j = 0; j < i; j++){
                if(solution.get(i) == solution.get(j))
                    return false;
                else if(Math.abs(solution.get(i) - solution.get(j)) == Math.abs(i - j))
                    return false;
            }
        }

        return true;
    }

};