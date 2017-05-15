package GasStation;

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here

        if(gas == null || gas.length == 0 || gas.length != cost.length)
            return -1;

        int totalGas = 0;
        int totalCost = 0;

        for(int g: gas)
            totalGas += g;
        for(int c: cost)
            totalCost += c;

        if(totalGas < totalCost)
            return -1;

        int curr = 0;

        int start = 0;
        int end = 0;

        while(end < gas.length){
            curr += gas[end] - cost[end];

            if(curr < 0){
                start = end + 1;
                end = start;
                curr = 0;
            }
            else{
                end++;
            }
        }

        return start;
    }
}
