package ValidNumber;

public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;

        s = s.trim();
        if(s.length() == 0)
            return false;

        int start = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            start = 1;

        boolean dot = false;
        boolean exp = false;
        boolean num = false;

        for(int i = start; i < s.length(); i++){
            char c = s.charAt(i);

            if(c >= '0' && c <= '9'){
                num = true;
            }
            else if(c == '.'){
                if(dot || exp){
                    return false;
                }
                else{
                    dot = true;
                }
            }
            else if(c == 'e'){
                if(exp || i == start){
                    return false;
                }
                else{
                    exp = true;
                    num = false;
                }
            }
            else if(c == '+' || c == '-'){
                if(i > start && s.charAt(i - 1) == 'e')
                    continue;
                else
                    return false;
            }
            else
                return false;
        }

        return num;
    }
}
