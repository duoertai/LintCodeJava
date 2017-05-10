package TwoSum;

import java.util.HashMap;

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length < 2)
            return new int[0];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];

        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(numbers[i])){
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            map.put(target - numbers[i], i);
        }

        return res;
    }
}
