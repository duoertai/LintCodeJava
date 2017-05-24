package SystemLongestFilePath;

public class Solution {
    /**
     * @param input an abstract file system
     * @return return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // Write your code here
        if(input == null || input.length() == 0)
            return 0;

        int longest = 0;
        String res = "";

        String[] strs = input.split("\n");
        String prefix = strs[0];
        int lastLevel = 0;

        for(int i = 1; i < strs.length; i++){
            //System.out.println(strs[i]);
            int level = getLevel(strs[i]);
            strs[i] = strs[i].substring(level);
            //System.out.println(strs[i] + "level" + level);
            if(level == lastLevel + 1){
                prefix = prefix + "/" + strs[i];

                if(isFile(strs[i])){
                    if(prefix.length() > longest){
                        longest = prefix.length();
                        res = prefix;
                        //System.out.println(res);
                    }
                }
            }
            else{
                int l = 0;
                int index = 0;
                while(index < prefix.length() && l <= level - 1){
                    if(prefix.charAt(index) == '/'){
                        l++;
                        index++;
                    }
                    else{
                        index++;
                    }
                }

                prefix = prefix.substring(0, index) + strs[i];
                if(isFile(strs[i])){
                    if(prefix.length() > longest){
                        longest = prefix.length();
                        res = prefix;
                        //System.out.println(res);

                    }
                }
            }

            lastLevel = level;
        }

        return longest;
    }

    public boolean isFile(String s){
        s = s.trim();
        if(s == null || s.length() == 0)
            return false;

        for(int i = 0; i < s.length() - 1; i++)
            if(s.charAt(i) == '.')
                return true;

        return false;
    }

    public int getLevel(String s){
        int res = 0;
        int i = 0;

        while(i + 1 < s.length()){
            char temp = s.charAt(i);
            if(temp == '\t'){
                res++;
                i = i + 1;
            }
            else{
                break;
            }
        }

        return res;
    }
}