package SortLettersByCase;

public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if(chars == null || chars.length == 0)
            return;

        int left = 0;
        int i = 0;
        int right = chars.length - 1;

        while(i <= right){
            if(chars[i] >= 'a' && chars[i] <= 'z')
                swap(chars, i++, left++);
            else
                i++;
        }

        return;
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return;
    }
}
