package trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @author Albina Gimaletdinova on 02/07/2022
 */
public class TriePrefixTree {
    // solution 1
    class Trie {
        private Map<Character, Set<String>> map;

        /** Initialize your data structure here. */
        public Trie() {
            map = new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.isEmpty()) return;

            Character key = word.charAt(0);
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                Set<String> set = new HashSet<>();
                set.add(word);
                map.put(key, set);
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null || word.isEmpty()) return false;

            Character key = word.charAt(0);
            Set<String> set = map.get(key);
            if (set == null) return false;

            return set.contains(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) return false;

            Character key = prefix.charAt(0);
            Set<String> set = map.get(key);
            if (set == null) return false;

            for (String s : set) {
                if (s.startsWith(prefix)) return true;
            }
            return false;
        }
    }
}
