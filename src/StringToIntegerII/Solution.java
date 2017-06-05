package StringToIntegerII;

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        if(str == null || str.length() == 0)
            return 0;

        str = str.trim();
        int count = 0;
        int index = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '.'){
                index = i;
                count++;
            }
        }

        if(count > 1)
            return 0;

        if(count == 1)
            str = str.substring(0, index);

        long res = 0;
        int start = 0;
        boolean neg = false;

        if(str.charAt(0) == '-'){
            neg = true;
            start = 1;
        }
        else if(str.charAt(0) == '+'){
            start = 1;
        }

        for(int i = start; i < str.length(); i++){
            char c = str.charAt(i);

            if(c > '9' || c < '0')
                break;

            res = res * 10 + (c - '0');
            if(!neg && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(neg && ((-1 * res) < Integer.MIN_VALUE))
                return Integer.MIN_VALUE;
        }

        if(neg)
            return (int) (-1 * res);
        else
            return (int) res;
    }
}