package trees;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @author Albina Gimaletdinova on 04/07/2022
 */
public class TriePrefixTree2 {
    // solution 2
    class TrieNode {
        private final int R = 26;
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // O(n) - time&space, where n - is the word's length
        public void insert(String word) {
            if (word == null || word.isEmpty()) return;

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        // O(n) time, O(1) space - see searchPrefix()
        public boolean search(String word) {
            if (word == null || word.isEmpty()) return false;

            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        // O(n) time, O(1) space - see searchPrefix()
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) return false;

            TrieNode node = searchPrefix(prefix);
            return node != null;
        }

        // O(n) time, O(1) space
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    return null;
                } else {
                    node = node.get(ch);
                }
            }
            return node;
        }
    }
}
