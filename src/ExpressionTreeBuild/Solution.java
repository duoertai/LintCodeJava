package ExpressionTreeBuild;

import Common.ExpressionTreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        if(expression == null || expression.length == 0)
            return null;

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
            return null;

        Stack<ExpressionTreeNode> stack2 = new Stack<ExpressionTreeNode>();

        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);

            if(isNum(s)){
                stack2.push(new ExpressionTreeNode(s));
            }
            else{
                ExpressionTreeNode temp = new ExpressionTreeNode(s);
                temp.right = stack2.pop();
                temp.left = stack2.pop();
                stack2.push(temp);
            }
        }

        return stack2.pop();
    }

    public boolean isNum(String s){
        boolean res = (!s.equals("(")) && (!s.equals(")")) && (!s.equals("+")) && (!s.equals("-")) && (!s.equals("*")) && (!s.equals("/"));
        return res;
    }
}