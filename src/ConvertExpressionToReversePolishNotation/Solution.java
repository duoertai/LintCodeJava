package ConvertExpressionToReversePolishNotation;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> res = new ArrayList<String>();

        if(expression == null || expression.length == 0)
            return res;

        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < expression.length; i++){
            String s = expression[i];

            if(isNum(s)){
                res.add(s);
            }
            else if(s.equals("(")){
                stack.push(s);
            }
            else if(s.equals(")")){
                while(!stack.isEmpty() && (!stack.peek().equals("("))){
                    res.add(stack.pop());
                }
                stack.pop();
            }
            else if(s.equals("*") || s.equals("/")){
                while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))){
                    res.add(stack.pop());
                }
                stack.push(s);
            }
            else if(s.equals("+") || s.equals("-")){
                while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("+") || stack.peek().equals("-"))){
                    res.add(stack.pop());
                }

                stack.push(s);
            }
        }

        while(!stack.isEmpty())
            res.add(stack.pop());

        return res;
    }

    public boolean isNum(String s){
        boolean res = (!s.equals("(")) && (!s.equals(")")) && (!s.equals("+")) && (!s.equals("-")) && (!s.equals("*")) && (!s.equals("/"));

        return res;
    }
}