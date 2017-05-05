package CountAndSay;

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if(n < 0)
            return "";

        if(n == 1)
            return "1";

        StringBuilder next = new StringBuilder();
        String curr = "1";

        for(int i = 1; i < n; i++){
            int p = 1;
            char c = curr.charAt(0);
            int num = 1;
            while(p <= curr.length()){
                while(p < curr.length() && curr.charAt(p) == c){
                    p++;
                    num++;
                }
                next.append(num).append(c);

                if(p == curr.length())
                    break;

                c = curr.charAt(p);
                num = 1;
                p++;
            }
            curr = next.toString();
            next = new StringBuilder();
        }

        return curr;
    }
}
