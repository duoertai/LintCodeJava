package UpdateBits;

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask1 = (1 << i) - 1;
        int mask2 = 0;

        if(j == 31)
            mask2 = 0;
        else
            mask2 = ~0 - ((1 << (j + 1)) - 1);
        int mask = mask1 + mask2;
        n = n & mask;
        n = n | (m << i);

        return n;
    }
}
