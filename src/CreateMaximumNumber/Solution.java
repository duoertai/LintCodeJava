package CreateMaximumNumber;

public class Solution {
    /**
     * @param nums1 an integer array of length m with digits 0-9
     * @param nums2 an integer array of length n with digits 0-9
     * @param k an integer and k <= m + n
     * @return an integer array
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(k <= 0)
            return new int[0];

        int m = nums1.length;
        int n = nums2.length;

        int max = m >= k ? k : m;
        int min = n >= k ? 0 : k - n;
        int[] res = new int[k];

        for(int i = min; i <= max; i++){
            int[] temp = merge(k, getMax(nums1, i), getMax(nums2, k - i));

            if(isGreater(temp, 0, res, 0))
                res = temp;
        }

        return res;
    }

    public boolean isGreater(int[] nums1, int start1, int[] nums2, int start2){
        int i = start1;
        int j = start2;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j])
                return true;
            if(nums1[i] < nums2[j])
                return false;
            i++;
            j++;
        }

        return i != nums1.length;
    }

    public int[] merge(int k, int[] nums1, int[] nums2){
        int[] res = new int[k];

        int i = 0;
        int j = 0;
        int index = 0;

        while(i < nums1.length || j < nums2.length){

            if(isGreater(nums1, i, nums2, j)){
                res[index++] = nums1[i++];
            }
            else{
                res[index++] = nums2[j++];
            }
        }

        return res;
    }

    public int[] getMax(int[] nums, int len){
        if(len == 0)
            return new int[0];

        int[] res = new int[len];
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            while(index > 0 && nums.length - i > len - index && nums[i] > res[index - 1])
                index--;

            if(index < len)
                res[index++] = nums[i];
        }

        return res;
    }

}