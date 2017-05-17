package LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();

        if(nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);

        int n = nums.length;
        int[] count = new int[n];
        int[] last = new int[n];

        for(int i = 0; i < n; i++){
            count[i] = 1;
            last[i] = -1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && count[i] < count[j] + 1){
                    count[i] = count[j] + 1;
                    last[i] = j;
                }
            }
        }

        int max = 0;
        int max_index = -1;

        for(int i = 0; i < n; i++){
            if(count[i] > max){
                max = count[i];
                max_index = i;
            }
        }

        while(last[max_index] != -1){
            res.add(nums[max_index]);
            max_index = last[max_index];
        }
        res.add(nums[max_index]);

        return res;
    }
}
