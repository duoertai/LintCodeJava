package CoinsInALineII;

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length <= 2)
            return true;

        int n = values.length;

        if(values.length == 3)
            return values[0] + values[1] > values[2];
        if(values.length == 4)
            return values[n - 4] + values[n - 3] > values[n - 2] + values[n - 1] || values[n - 4] + values[n - 1] > values[n - 2] + values[n - 3];

        int[] first = new int[n];
        first[n - 1] = values[n - 1];
        first[n - 2] = values[n - 1] + values[n - 2];
        first[n - 3] = values[n - 3] + values[n - 2];
        first[n - 4] = values[n - 4] + Math.max(values[n - 3], values[n - 1]);

        for(int i = n - 5; i >= 0; i--){
            int one = values[i] + Math.min(first[i + 2], first[i + 3]);
            int two = values[i] + values[i + 1] + Math.min(first[i + 3], first[i + 4]);

            first[i] = Math.max(one, two);
        }

        int sum = 0;
        for(int v: values)
            sum += v;

        return first[0] > sum - first[0];
    }
}
