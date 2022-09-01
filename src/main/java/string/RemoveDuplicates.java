package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * @author Albina Gimaletdinova on 01/09/2022
 */
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                char prev = stack.peek();
                if (prev == cur) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }

        if (stack.isEmpty()) return "";

        char[] res = new char[stack.size()];
        int i = res.length - 1;
        while (i >= 0) {
            res[i] = stack.pop();
            i--;
        }
        return new String(res);
    }
}
