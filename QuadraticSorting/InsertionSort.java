package QuadraticSorting;

// Complexity O(n^2)
public class InsertionSort {

    public static void insertionSort (int[] data) {
        int n = data.length;

        for (int k = 1; k < n - 1; k++) {
            int cur = data[k];
            int j = k;
            while (j > 0 && data[j-1] > cur) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur;
        }
    }
}
