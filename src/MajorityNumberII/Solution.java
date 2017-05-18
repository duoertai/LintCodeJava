package MajorityNumberII;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code

        Integer num1 = null;
        Integer num2 = null;
        int count1 = 0;
        int count2 = 0;
        int res = 0;

        for(int i = 0; i < nums.size(); i++){
            int temp = nums.get(i);

            if(num1 == null){
                num1 = temp;
                count1 = 1;
            }
            else if(num1 == temp){
                count1++;
            }
            else if(num2 == null){
                num2 = temp;
                count2 = 1;
            }
            else if(num2 == temp){
                count2++;
            }
            else{
                count1--;
                if(count1 == 0){
                    num1 = null;
                }

                count2--;
                if(count2 == 0){
                    num2 = null;
                }
            }
        }

        count1 = 0;
        if(num1 != null){
            for(int n: nums)
                if(n == num1)
                    count1++;

            if(count1 > nums.size() / 3)
                return num1;
        }

        count2 = 0;
        if(num2 != null){
            for(int n: nums)
                if(n == num2)
                    count2++;

            if(count2 > nums.size() / 3)
                return num2;
        }

        return 0;
    }
}

