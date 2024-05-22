package QuadraticSorting;

// Complexity O(n^2)
public class SelectionSort {

    public static void selectionSort (int[] data) {
        int n = data.length;

        for (int k = 0; k < n - 1; k++) {

            int min  = k;

            for (int j = k + 1; j < n; j++) 

                if (data[j] < data[min])
                    min = j;

            int temp = data[k];
            data[k] = data[min];
            data[min] = temp;
        }
    }
}
