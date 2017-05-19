package MaximumAverageSubarray;

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here

        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;

        for(int n: nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        while(min < max - 1e-9){
            double avg = min + (max - min) / 2;

            if(valid(nums, avg, k))
                min = avg;
            else
                max = avg;
        }

        return min;
    }

    public boolean valid(int[] nums, double avg, int k){
        int n = nums.length;
        double min_pre = 0.0;
        double[] sum = new double[n + 1];
        sum[0] = 0.0;

        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + nums[i - 1] - avg;

            if(i >= k && sum[i] - min_pre >= 0)
                return true;

            if(i >= k)
                min_pre = Math.min(min_pre, sum[i - k + 1]);
        }

        return false;
    }

}