package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(numbers == null || numbers.length == 0)
            return res;

        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length - 2; i++){
            if(i > 0 && numbers[i] == numbers[i - 1])
                continue;

            int left = i + 1;
            int right = numbers.length - 1;

            while(left < right){

                if(numbers[i] + numbers[left] + numbers[right] < 0){
                    left++;
                }
                else if(numbers[i] + numbers[left] + numbers[right] > 0){
                    right--;
                }
                else{
                    ArrayList<Integer> line = new ArrayList<Integer>();
                    line.add(numbers[i]);
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

        return res;
    }
}
