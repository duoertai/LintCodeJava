package ThreeSumClosest;

import java.util.Arrays;

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here

        if(numbers == null || numbers.length < 3)
            return 0;

        Arrays.sort(numbers);
        Integer res = Integer.MAX_VALUE;

        for(int i = 0; i < numbers.length - 2; i++){
            int left = i + 1;
            int right = numbers.length - 1;

            while(left < right){

                if(Math.abs(numbers[i] + numbers[left] + numbers[right] - target) < Math.abs(res - target))
                    res = numbers[i] + numbers[left] + numbers[right];

                if(numbers[i] + numbers[left] + numbers[right] < target){
                    left++;
                }
                else if(numbers[i] + numbers[left] + numbers[right] > target){
                    right--;
                }
                else{
                    return target;
                }
            }
        }

        return res;
    }
}

