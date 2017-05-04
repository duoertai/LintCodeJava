package CompareStrings;

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here

        if(empty(A) && empty(B))
            return true;

        if(empty(A))
            return false;

        if(empty(B))
            return true;

        int[] count = new int[26];
        for(int i = 0; i < A.length(); i++){
            count[A.charAt(i) - 'A']++;
        }

        for(int i = 0; i < B.length(); i++){
            count[B.charAt(i) - 'A']--;
            if(count[B.charAt(i) - 'A'] < 0)
                return false;
        }

        return true;
    }

    public boolean empty(String s){
        return (s == null) || (s.length() == 0);
    }
}