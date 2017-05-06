package IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;

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
        HashSet<Integer> n1 = new HashSet<Integer>();
        HashSet<Integer> n2 = new HashSet<Integer>();

        for(int i = 0; i < nums1.length; i++){
            n1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            if(n1.contains(nums2[i]) && !n2.contains(nums2[i]))
                res.add(nums2[i]);

            n2.add(nums2[i]);
        }

        int[] result = new int[res.size()];

        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);

        return result;
    }
}
