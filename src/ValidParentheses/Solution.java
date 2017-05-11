package ValidParentheses;

import java.util.Stack;

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if(s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.isEmpty())
                    return false;

                if(stack.peek() != '(')
                    return false;

                stack.pop();
            }
            else if(c == ']'){
                if(stack.isEmpty())
                    return false;

                if(stack.peek() != '[')
                    return false;

                stack.pop();
            }
            else if(c == '}'){
                if(stack.isEmpty())
                    return false;

                if(stack.peek() != '{')
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
