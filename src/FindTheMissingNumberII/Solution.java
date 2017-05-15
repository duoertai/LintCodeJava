package FindTheMissingNumberII;

import java.util.HashSet;

public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
    public int findMissing2(int n, String str) {
        // Write your code here
        HashSet<Integer> set = new HashSet<Integer>();
        helper(set, n, str, 0);

        int sum = 0;
        for(int i: set){
            sum += i;
        }

        return n * (n + 1) / 2 - sum;
    }

    public boolean helper(HashSet<Integer> set, int n, String str, int start){
        if(set.size() == n - 1 && start == str.length())
            return true;

        if(set.size() == n - 1 || start >= str.length())
            return false;

        String single_str = str.substring(start, start + 1);
        if(valid(n, single_str)){
            int single_num = Integer.parseInt(single_str);
            if(!set.contains(single_num)){
                set.add(single_num);
                if(helper(set, n, str, start + 1))
                    return true;
                set.remove(single_num);
            }
        }



        String double_str = str.substring(start, start + 2);
        if(valid(n, double_str)){
            int double_num = Integer.parseInt(double_str);
            if(!set.contains(double_num)){
                set.add(double_num);
                if(helper(set, n, str, start + 2))
                    return true;
                set.remove(double_num);
            }
        }

        return false;
    }

    public boolean valid(int n, String s){
        if(s.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(s);
        return num >= 1 && num <= n;
    }
}