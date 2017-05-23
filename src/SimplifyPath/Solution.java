package SimplifyPath;

import java.util.Stack;

public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
            return path;

        StringBuilder res = new StringBuilder();
        int start = 0;
        int end = 1;
        int len = path.length();
        Stack<String> stack = new Stack<String>();

        while(end < len){
            while(end < len && path.charAt(end) != '/')
                end++;

            String temp = path.substring(start, end);

            if(temp.equals("/..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(temp.equals("/") || temp.equals("/.")){

            }
            else{
                stack.push(temp);
            }

            start = end;
            end++;
        }

        while(!stack.isEmpty()){
            res.insert(0, stack.pop());
        }

        if(res.length() == 0){
            return "/";
        }

        return res.toString();
    }
}
