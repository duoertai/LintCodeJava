package Singleton;

class Solution {
    /**
     * @return: The same instance of this class every time
     */

    private static Solution singleton = new Solution();
    public static Solution getInstance() {
        // write your code here
        return Solution.singleton;
    }
}
