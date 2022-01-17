package array;

/**
 * https://leetcode.com/problems/can-place-flowers/
 *
 * @author Albina Gimaletdinova on 17/01/2022
 */
public class CanPlaceFlowers {
    /**
     * O(n) - time
     * O(1) - space
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) continue;
            boolean leftOk = (i == 0 && flowerbed[i] == 0) ||
                    (i > 0 && i < m && flowerbed[i - 1] == 0);
            boolean rightOk = (i == m - 1 && flowerbed[i] == 0) ||
                    (i < m - 1 && flowerbed[i + 1] == 0);
            if (leftOk && rightOk) {
                flowerbed[i] = 1;
                res++;
            }
            if (res >= n) return true;
        }
        return res >= n;
    }
}
