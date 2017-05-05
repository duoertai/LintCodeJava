package FlipBits;

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int diff = a ^ b;
        int count = 0;

        for(int i = 0; i < 32; i++){
            if(((diff >> i) & 1) == 1)
                count++;
        }

        return count;
    }
}

