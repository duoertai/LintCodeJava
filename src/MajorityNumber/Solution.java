package MajorityNumber;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code

        if(nums == null || nums.size() == 0)
            return 0;

        int res = nums.get(0);
        int count = 1;

        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i) == res){
                count++;
            }
            else{
                count--;
                if(count < 0)
                    res = nums.get(i);
            }
        }

        return res;
    }
}
