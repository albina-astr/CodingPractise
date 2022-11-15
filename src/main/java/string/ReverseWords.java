package string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * @author Albina Gimaletdinova on 15/11/2022
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        s = s.trim();
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);

        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            end = start;
            while (end < arr.length && arr[end] != ' ') {
                end++;
            }
            int counter = end - 1;
            while (counter < arr.length && counter >= start) {
                result.append(arr[counter--]);
            }
            if (end < arr.length) {
                result.append(' ');
            }

            start = end;
            while (start < arr.length && arr[start] == ' ') {
                start++;
            }
        }
        return result.toString();
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
