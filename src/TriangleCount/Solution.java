package TriangleCount;

import java.util.Arrays;

public class Solution {
    public int triangleCount(int s[]) {
        // write your code here
        if(s == null || s.length < 3)
            return 0;

        Arrays.sort(s);
        int res = 0;

        for(int i = 0; i < s.length - 1; i++){
            for(int j = 0; j < i; j++){
                int index = search(s, i + 1, s.length - 1, s[i] + s[j]);
                if(index != -1)
                    res += index - i;
            }
        }

        return res;
    }

    public int search(int[] nums, int start, int end, int target){

        if(nums[start] >= target)
            return -1;

        while(start < end - 1){
            int mid = start + (end - start) / 2;

            if(nums[mid] < target)
                start = mid;
            else
                end = mid;
        }

        if(nums[end] < target)
            return end;
        else if(nums[start] < target)
            return start;
        else
            return -1;
    }

}
