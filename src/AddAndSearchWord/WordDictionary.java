package AddAndSearchWord;

public class WordDictionary {
    class node{
        node[] children;
        String item;

        public node(){
            this.children = new node[26];
            String item = null;
        }
    }

    node root = new node();

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here

        if(word == null || word.length() == 0)
            return;

        node temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(temp.children[c - 'a'] == null)
                temp.children[c - 'a'] = new node();
            temp = temp.children[c - 'a'];
        }

        temp.item = word;
        return;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here

        if(word == null || word.length() == 0)
            return true;

        return search(root, word, 0);
    }

    public boolean search(node root, String word, int index){
        if(index == word.length()){
            return root.item != null;
        }

        char c = word.charAt(index);

        if(c != '.'){
            if(root.children[c - 'a'] == null)
                return false;
            else
                return search(root.children[c - 'a'], word, index + 1);
        }
        else{
            for(int i = 0; i < 26; i++){
                if(root.children[i] != null){
                    if(search(root.children[i], word, index + 1))
                        return true;
                }
            }
            return false;
        }
    }

}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
