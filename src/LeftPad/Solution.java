package LeftPad;

public class Solution {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here

        if(size <= originalStr.length())
            return originalStr;

        StringBuilder builder = new StringBuilder(originalStr);

        for(int i = 0; i < size - originalStr.length(); i++)
            builder.insert(0, ' ');

        return builder.toString();
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here

        if(size <= originalStr.length())
            return originalStr;

        StringBuilder builder = new StringBuilder(originalStr);

        for(int i = 0; i < size - originalStr.length(); i++)
            builder.insert(0, padChar);

        return builder.toString();
    }
}
