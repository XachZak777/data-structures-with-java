package EfficientSorting;

import java.util.Arrays;

// Worst Case O(n^2)
// Avarage Case O(n log n)
public class QuickSort {
    
    public static void quickSort (int[] S) {
        int n = S.length;
        if (n < 2) return;

        // Divide.

        int pivot = S[n-1];
        int m = 0, k = n;
        int [] temp = new int[n];

        for (int i = 0; i < n - 1; i++)
            if (S[i] < pivot) 
                temp[m++] = S[i];
            else if (S[i] > pivot) 
                temp[--k] = S[i];
        int[] L = Arrays.copyOfRange(temp, 0, m);
        int[] E = new int[k - m];
        Arrays.fill(E, pivot);
        int[] G = Arrays.copyOfRange(temp, k, n);

        // Conquer

        quickSort(L);
        quickSort(G);

        // Results
        
        System.arraycopy(L, 0, S, 0, m);
        System.arraycopy(E, 0, S, m, k-m);
        System.arraycopy(G, 0, S, k, n-k);
    }
}
