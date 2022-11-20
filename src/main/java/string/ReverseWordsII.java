package string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 *
 * @author Albina Gimaletdinova on 20/11/2022
 */
public class ReverseWordsII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        reverse(s, 0, s.length - 1);

        int from = 0, to = s.length - 1;
        while (to < s.length && from < s.length) {
            to = from;
            while (to < s.length && s[to] != ' ') {
                to++;
            }

            if (to == s.length - 1) {
                reverse(s, from, to);
            } else {
                reverse(s, from, to - 1);
            }
            from = to;

            while (from < s.length && s[from] == ' ') {
                from++;
            }
        }
    }

    private void reverse(char[] arr, int from, int to) {
        while (from < to) {
            char tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
            from++;
            to--;
        }
    }
}
