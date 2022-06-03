package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * @author Albina Gimaletdinova on 28/02/2023
 */
public class WordsFormedFromCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] dict = new int[26];
        for (char ch : chars.toCharArray()) {
            dict[ch - 'a']++;
        }

        int res = 0;
        for (String word : words) {
            int[] dictCopy = Arrays.copyOf(dict, dict.length);
            int len = 0;
            for (char ch : word.toCharArray()) {
                if (--dictCopy[ch - 'a'] < 0) {
                    break;
                }
                len++;
                if (len == word.length()) {
                    res += word.length();
                }
            }
        }
        return res;
    }
}
