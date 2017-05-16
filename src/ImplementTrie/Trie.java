package ImplementTrie;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] children;
    public String item;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.item = null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0)
            return;

        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(temp.children[c - 'a'] == null)
                temp.children[c - 'a'] = new TrieNode();

            temp = temp.children[c - 'a'];
        }

        temp.item = word;
        return;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0)
            return true;

        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(temp.children[c - 'a'] == null)
                return false;

            temp = temp.children[c - 'a'];
        }

        return temp.item != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0)
            return true;

        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);

            if(temp.children[c - 'a'] == null)
                return false;

            temp = temp.children[c - 'a'];
        }

        return true;
    }
}
