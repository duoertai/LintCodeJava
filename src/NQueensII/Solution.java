package NQueensII;


import java.util.ArrayList;

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();

        helper(res, solution, n);

        return res.size();
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
}

