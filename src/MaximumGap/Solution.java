package MaximumGap;

class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;

        int maxDigitNum = 0;
        for(int n: nums)
            maxDigitNum = Math.max(maxDigitNum, getDigitNum(n));

        int n = nums.length;
        int[] temp = new int[n];

        int factor = 1;

        for(int i = 0; i < maxDigitNum; i++){
            int[] count = new int[10];

            for(int num: nums)
                count[(num / factor) % 10]++;

            for(int j = 1; j < 10; j++)
                count[j] += count[j - 1];

            for(int j = nums.length - 1; j >= 0; j--){
                temp[count[(nums[j] / factor) % 10] - 1] = nums[j];
                count[(nums[j] / factor) % 10]--;
            }

            for(int j = 0; j < nums.length; j++)
                nums[j] = temp[j];

            factor *= 10;
        }

        int res = 0;
        for(int i = 1; i < nums.length; i++)
            res = Math.max(res, nums[i] - nums[i - 1]);

        return res;
    }

    public int getDigitNum(int num){
        if(num == 0)
            return 1;

        int res = 0;
        while(num > 0){
            num /= 10;
            res++;
        }

        return res;
    }
}