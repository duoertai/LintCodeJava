package RomanToInteger;

public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        if(s == null || s.length() == 0)
            return 0;

        int res = 0;
        for(int i = 0; i < s.length() - 1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if(getNum(c1) < getNum(c2))
                res -= getNum(c1);
            else
                res += getNum(c1);
        }
        res += getNum(s.charAt(s.length() - 1));

        return res;
    }

    public int getNum(char c){
        if(c == 'I')
            return 1;
        if(c == 'V')
            return 5;
        if(c == 'X')
            return 10;
        if(c == 'L')
            return 50;
        if(c == 'C')
            return 100;
        if(c == 'D')
            return 500;
        if(c == 'M')
            return 1000;

        return 0;
    }

}