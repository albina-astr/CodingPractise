package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number/
 *
 * @author Albina Gimaletdinova on 06/07/2022
 */
public class LargestNumber {
    private class LargestStringComparator
            implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] arr) {
        if (arr == null || arr.length == 0) return "";

        String[] strings = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strings[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strings, new LargestStringComparator());

        if (strings[0].equals("0")) return "0";

        StringBuilder res = new StringBuilder();
        for (String str : strings) {
            res.append(str);
        }
        return res.toString();
    }
}
