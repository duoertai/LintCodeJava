package FindMinimumInRotatedSortedArrayII;

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here

        if(num == null || num.length == 0)
            return 0;

        int left = 0;
        int right = num.length - 1;

        if(num[left] < num[right])
            return num[left];

        while(left < right - 1){
            if(num[left] == num[right])
                left++;
            else if(num[left] < num[right])
                return num[left];

            int mid = left + (right - left) / 2;
            if(num[left] < num[mid])
                left = mid;
            else if(num[left] == num[mid])
                left++;
            else
                right = mid;
        }

        return Math.min(num[left], num[right]);
    }
}