package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 *
 * @author Albina Gimaletdinova on 05/08/2022
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> dict = new HashMap<>();
        int windowStart = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++)
        {
            int cur = arr[windowEnd];
            dict.put(cur, dict.getOrDefault(cur, 0) + 1);

            while (dict.size() > 2) {
                int leftmost = arr[windowStart];
                int count = dict.get(leftmost);
                if (count - 1 == 0) {
                    dict.remove(leftmost);
                } else {
                    dict.put(leftmost, count - 1);
                }
                windowStart++;
            }
            maxCount = Math.max(maxCount, windowEnd - windowStart +1);
        }
        return maxCount == Integer.MIN_VALUE ? 0 : maxCount;
    }
}
