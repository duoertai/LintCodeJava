package ExpressionEvaluation;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        if(expression == null || expression.length == 0)
            return 0;

        ArrayList<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < expression.length; i++){
            String s = expression[i];

            if(isNum(s)){
                list.add(s);
            }
            else if(s.equals("(")){
                stack.push(s);
            }
            else if(s.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    list.add(stack.pop());
                }
                stack.pop();
            }
            else if(s.equals("*") || s.equals("/")){
                while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))){
                    list.add(stack.pop());
                }
                stack.push(s);
            }
            else if(s.equals("+") || s.equals("-")){
                while(!stack.isEmpty() && (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("/"))){
                    list.add(stack.pop());
                }
                stack.push(s);
            }
        }

        while(!stack.isEmpty())
            list.add(stack.pop());

        if(list.size() == 0)
            return 0;

        Stack<Integer> stack2 = new Stack<Integer>();
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);

            if(isNum(s)){
                stack2.push(Integer.valueOf(s));
            }
            else if(s.equals("+")){
                int n1 = stack2.pop();
                int n2 = stack2.pop();
                stack2.push(n1 + n2);
            }
            else if(s.equals("-")){
                int n1 = stack2.pop();
                int n2 = stack2.pop();
                stack2.push(n2 - n1);
            }
            else if(s.equals("*")){
                int n1 = stack2.pop();
                int n2 = stack2.pop();
                stack2.push(n1 * n2);
            }
            else if(s.equals("/")){
                int n1 = stack2.pop();
                int n2 = stack2.pop();
                stack2.push(n2 / n1);
            }
        }

        return stack2.pop();
    }

    public boolean isNum(String s){
        boolean res = (!s.equals("(")) && (!s.equals(")")) && (!s.equals("+")) && (!s.equals("-")) && (!s.equals("*")) && (!s.equals("/"));
        return res;
    }
}