package PermutationSequence;

class Solution {
    /**
     * @param n: n
     * @param k: the kth permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        k--;

        if(k < 0 || k > factor(n))
            return "";

        StringBuilder num = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(int i = 1; i <= n; i++)
            num.append(i);

        for(int i = n - 1; i >= 0; i--){
            long temp = factor(i);
            res.append(num.charAt((int) (k / temp)));
            num.deleteCharAt((int) (k / temp));
            k = k % ((int) temp);
        }

        return res.toString();
    }

    public long factor(int n){
        long num = 1;

        for(int i = 1; i <= n; i++)
            num *= i;

        return num;
    }

}

