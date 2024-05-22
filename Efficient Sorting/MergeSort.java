import java.util.Arrays;

public class MergeSort {

    // Merge Sort algorithm implementation
    public static void mergeSort (int[] S) {
        int n = S.length;
        if (n < 2) return;

        // Divide.

        int mid = n/2;

        int[] S1 = Arrays.copyOfRange(S, 0, mid);
        int[] S2 = Arrays.copyOfRange(S, mid, n);

        // Conquer.
        
        mergeSort(S1);
        mergeSort(S2);

        // Merge.

        merge(S1, S2, S);
    }

    // Merge of 2 arrays into one.
    private static void merge (int[] S1, int[] S2, int[] S) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i] < S2[j]))
                S[i + j] = S1[i++];
            else
                S[i + j] = S2[j++];
        }
    }
}