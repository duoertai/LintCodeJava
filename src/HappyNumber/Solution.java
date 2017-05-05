package HappyNumber;

import java.util.HashSet;

public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        if(n <= 0)
            return false;

        if(n == 1)
            return true;

        HashSet<Integer> set = new HashSet<Integer>();

        while(true){
            if(set.contains(n))
                return false;

            set.add(n);

            int next = 0;
            while(n > 0){
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            if(next == 1)
                return true;

            n = next;
        }

    }
}