package array;

/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * @author Albina Gimaletdinova on 01/12/2022
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length - 1] = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            //optimization
            if (arr[i + 1] > arr[i]) {
                res[i] = 1;
                continue;
            }
            for (int k = i + 1; k < arr.length; k += res[k]) {
                if (arr[k] > arr[i]) {
                    res[i] = k - i;
                    break;
                }
                if (res[k] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }

        return res;
    }
}
