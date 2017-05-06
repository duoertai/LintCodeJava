package IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums1.length; i++){
            if(!map1.containsKey(nums1[i]))
                map1.put(nums1[i], 0);

            map1.put(nums1[i], map1.get(nums1[i]) + 1);
        }

        for(int i = 0; i < nums2.length; i++){
            if(map1.containsKey(nums2[i]) && map1.get(nums2[i]) > 0){
                res.add(nums2[i]);
                map1.put(nums2[i], map1.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[res.size()];

        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);

        return result;
    }
}