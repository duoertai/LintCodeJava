package RotateString;

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length <= 1 || offset % str.length == 0)
            return;

        offset = offset % str.length;

        for(int i = 0; i < offset; i++)
            rotate(str);

        return;
    }

    public void rotate(char[] str){
        char c = str[str.length - 1];
        for(int i = str.length - 1; i >= 1; i--){
            str[i] = str[i - 1];
        }

        str[0] = c;
        return;
    }
}
