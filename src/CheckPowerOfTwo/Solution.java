package CheckPowerOfTwo;

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n <= 0)
            return false;

        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((n >> i) & 1) == 1)
                count++;
            if(count > 1)
                return false;
        }

        return count == 1;
    }
};
