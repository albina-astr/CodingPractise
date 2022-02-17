package array;

/**
 * @author Albina Gimaletdinova on 17/02/2022
 */
public class RemoveElement {
    /**
     * SOLUTION 1:
     * arr = [1, 4, 2, 3, 5, 6, 3, 2], val = 3
     *      i = 2
     */
    public int removeElement(int[] arr, int val) {
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[lastIndex++] = arr[i];
            }
        }
        return lastIndex; //without '+ 1' !!!
    }

    /**
     * SOLUTION 2 (if elements == val are rare)
     * elements can be placed ARBITRARY in an array
     */
    public int removeElement2(int[] arr, int val) {
        int i = 0, n = arr.length;
        while (i < n) {
            if (arr[i] == val) {
                int tmp = arr[n - 1];
                arr[n - 1] = arr[i];
                arr[i] = tmp;
                n--;
            } else {
                i++;
            }
        }
        return n; //or 'right' - does not matter
    }

}
