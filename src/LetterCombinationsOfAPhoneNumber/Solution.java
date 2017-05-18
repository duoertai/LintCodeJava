package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;

public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return res;

        helper(res, "", 0, digits, letters);

        return res;
    }

    public void helper(ArrayList<String> res, String str, int start, String digits, String[] letters){
        if(start == digits.length()){
            res.add(str);
            return;
        }

        int num = digits.charAt(start) - '0';
        String letter = letters[num];

        for(int i = 0; i < letter.length(); i++){
            char c = letter.charAt(i);
            helper(res, str + c, start + 1, digits, letters);
        }

        return;
    }
}