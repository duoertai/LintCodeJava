package ReorderArrayToConstructTheMinimumNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here

        if(nums == null || nums.length == 0)
            return "";

        Integer[] numbers = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)
            numbers[i] = nums[i];

        Arrays.sort(numbers, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                String s1 = "" + i1 + i2;
                String s2 = "" + i2 + i1;

                return s1.compareTo(s2);
            }
        });

        StringBuilder res = new StringBuilder();

        for(Integer n: numbers)
            res.append(n);

        while(res.length() > 1 && res.charAt(0) == '0')
            res.deleteCharAt(0);

        return res.toString();
    }
}