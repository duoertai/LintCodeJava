package SpaceReplacement;

public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here

        int count = 0;

        for(int i = 0; i < length; i++){
            if(string[i] == ' ')
                count++;
        }

        int res = length + count * 2;
        int j = res - 1;

        for(int i = length - 1; i >= 0; i--){
            if(string[i] != ' '){
                string[j--] = string[i];
            }
            else{
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
            }
        }

        return res;
    }
}