package Count1inBinary;

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        int count = 0;

        for(int i = 0; i < 32; i++){
            if(((num >> i) & 1) == 1)
                count++;
        }

        return count;
    }
};