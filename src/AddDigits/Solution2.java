package AddDigits;

public class Solution2 {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        // Write your code here
        if(num < 10)
            return num;

        return (num % 9) == 0 ? 9 : (num % 9);
    }
}
