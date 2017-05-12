package FourSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(numbers == null || numbers.length < 4)
            return res;

        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length - 3; i++){
            if(i > 0 && numbers[i] == numbers[i - 1])
                continue;

            for(int j = i + 1; j < numbers.length - 2; j++){
                if(j > i + 1 && numbers[j] == numbers[j - 1])
                    continue;

                int left = j + 1;
                int right = numbers.length - 1;

                while(left < right){
                    if(numbers[i] + numbers[j] + numbers[left] + numbers[right] < target){
                        left++;
                    }
                    else if(numbers[i] + numbers[j] + numbers[left] + numbers[right] > target){
                        right--;
                    }
                    else{
                        ArrayList<Integer> line = new ArrayList<Integer>();
                        line.add(numbers[i]);
                        line.add(numbers[j]);
                        line.add(numbers[left]);
                        line.add(numbers[right]);
                        res.add(line);

                        left++;
                        while(left < right && numbers[left] == numbers[left - 1])
                            left++;

                        right--;
                        while(left < right && numbers[right] == numbers[right + 1])
                            right--;
                    }
                }
            }
        }

        return res;
    }
}
