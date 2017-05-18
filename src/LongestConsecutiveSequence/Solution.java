package LongestConsecutiveSequence;

import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] num) {
        // write you code here

        if(num == null || num.length == 0)
            return 0;
        if(num.length == 1)
            return 1;

        HashSet<Integer> set = new HashSet<Integer>();
        for(int n: num)
            set.add(n);

        int max = 1;

        for(int i = 0; i < num.length; i++){
            if(!set.contains(num[i]))
                continue;

            int count = 1;
            int temp = num[i] + 1;
            while(set.contains(temp)){
                set.remove(temp);
                count++;
                temp++;
            }
            temp = num[i] - 1;
            while(set.contains(temp)){
                set.remove(temp);
                count++;
                temp--;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
