package SubarraySum;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(nums == null || nums.length == 0)
            return res;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int sum = 0;
        map.put(sum, 0);

        for(int i = 1; i < nums.length; i++){
            sum += nums[i - 1];

            if(map.containsKey(sum)){
                res.add(map.get(sum));
                res.add(i - 1);
                return res;
            }
            else{
                map.put(sum, i);
            }
        }

        sum += nums[nums.length - 1];
        res.add(map.get(sum));
        res.add(nums.length - 1);

        return res;
    }
}
