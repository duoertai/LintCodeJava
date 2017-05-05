package HashFunction;

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here

        if(key == null || key.length == 0)
            return 0;

        long res = 0;
        long factor = 1;

        for(int i = 0; i < key.length; i++){
            res += (key[key.length - 1 - i] * factor) % HASH_SIZE;
            res = res % HASH_SIZE;
            factor *= 33;
            factor = factor % HASH_SIZE;
        }

        return (int) res;
    }
};
