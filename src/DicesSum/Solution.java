package DicesSum;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair

        List<Map.Entry<Integer, Double>> res = new ArrayList<Map.Entry<Integer, Double>>();

        if(n <= 0)
            return res;

        int max = 6 * n;
        long[][] dp = new long[n + 1][max + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = i; j <= 6 * i; j++){
                for(int k = 1; k <= 6 && k <= j; k++){
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        long sum = 0;
        for(int i = n; i <= 6 * n; i++)
            sum += dp[n][i];

        for(int i = n; i <= 6 * n; i++){
            res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i] * 1.0 / sum));
        }

        return res;
    }
}