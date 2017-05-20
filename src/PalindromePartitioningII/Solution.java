package PalindromePartitioningII;

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() <= 1)
            return 0;

        int n = s.length();
        int[] cut = new int[n];

        cut[0] = 0;
        for(int i = 1; i < n; i++)
            cut[i] = i;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                String temp = s.substring(j, i + 1);

                if(isPalindrome(temp)){
                    if(j == 0)
                        cut[i] = 0;
                    else
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                }
            }
        }

        return cut[n - 1];
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
