package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * @author Albina Gimaletdinova on 06/04/2022
 */
public class ClimbingStairs {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        if (!memo.containsKey(n)) {
            int res = climbStairs(n - 1) + climbStairs(n - 2);
            memo.put(n, res);
        }
        return memo.get(n);
    }
}
