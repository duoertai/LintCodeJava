package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String largestNumber(int[] num) {
        // write your code here
        if(num == null || num.length == 0)
            return "";

        String[] nums = new String[num.length];
        for(int i = 0; i < num.length; i++)
            nums[i] = String.valueOf(num[i]);

        StringBuilder res = new StringBuilder();

        Arrays.sort(nums, new Comparator<String>(){
            public int compare(String s1, String s2){
                return -1 * (s1 + s2).compareTo(s2 + s1);
            }
        });

        for(String n: nums)
            res.append(n);

        while(res.length() > 1 && res.charAt(0) == '0')
            res.deleteCharAt(0);

        return res.toString();
    }
}