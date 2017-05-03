package AddDigits;

public class Solution1 {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        // Write your code here
        while(num >= 10){
            int sum = 0;

            while(num > 0){
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }
}