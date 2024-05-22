package QuadraticSorting;

// Complexity O(n^2)
public class BubbleSort {

    public static void bubbleSort (int[] data) {
        int n = data.length;
        
        for (int k = 0; k < n - 1; k++) {
            boolean swapped = false;
            for (int j = 0; j < n - k - 1; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    swapped = true;
                }
            if (!swapped)
                break;
            }
        }
    }
}
