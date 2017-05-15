package ExpressionExpand;

import java.util.Stack;

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here

        if(s == null || s.length() == 0)
            return s;

        Stack<String> prefixes = new Stack<String>();
        Stack<Integer> nums = new Stack<Integer>();

        int num = 0;
        StringBuilder prefix = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isNum(c)){
                num = 10 * num + (c - '0');
            }
            else if(isLetter(c)){
                prefix.append(c);
            }
            else if(c == '['){
                prefixes.push(prefix.toString());
                prefix = new StringBuilder();
                nums.push(num);
                num = 0;
            }
            else if(c == ']'){
                StringBuilder temp = new StringBuilder();
                temp.append(prefixes.pop());
                num = nums.pop();
                for(int j = 0; j < num; j++)
                    temp.append(prefix.toString());
                prefix = temp;
                num = 0;
            }
        }

        return prefix.toString();
    }

    public boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}
