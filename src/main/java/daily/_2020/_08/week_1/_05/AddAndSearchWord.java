package daily._2020._08.week_1._05;

import java.util.Collection;
import java.util.HashMap;

public class AddAndSearchWord {

    static class WordDictionary {

        private TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode current = root;
            for (char l: word.toCharArray()) {
                current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
            }
            current.setWord(true);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int pos, TrieNode node) {
            TrieNode current = node;
            for (int i = pos; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch == '.') {
                    if (current.getChildren().values().isEmpty()) {
                        return false;
                    }
                    for (TrieNode child : current.getChildren().values()) {
                        if (search(word, i + 1, child)) {
                            return true;
                        }
                    }
                    return false;
                }
                node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.isWord();
        }
    }

    static class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("at");
        obj.addWord("and");
        obj.addWord("an");
        obj.addWord("add");
        obj.addWord("bat");
//        obj.addWord("dad");
//        obj.addWord("mad");
//        System.out.println(obj.search("pad")); //-> false
//        System.out.println(obj.search("bad")); //-> true
//        System.out.println(obj.search(".ad")); //-> true
        System.out.println(obj.search(".at")); //-> true
//        obj.addWord("a");
//        obj.addWord("a");
//        System.out.println(obj.search("a."));
    }

}
