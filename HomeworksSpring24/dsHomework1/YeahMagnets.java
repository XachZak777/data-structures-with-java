package dsHomework1;

import java.util.Scanner;

public class YeahMagnets {
    /*
     * Best case: O(n)
     * 
     * This occurs when we simply read 
     * through the columns and sum up the cubes, then 
     * distribute them in one more pass through the columns.
     * 
     * Worst case: O(n) 
     * 
     * The worst-case runtime is also linear
     * since we still only make a single pass to read the 
     * input and another pass to distribute the cubes.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] cubes = new int[n];

        int totalCubes = 0;

        for (int i = 0; i < n; i++) {
            cubes[i] = scanner.nextInt();
            totalCubes += cubes[i];
        }

        int[] result = new int[n];

        int remainingCubes = totalCubes;

        for (int i = 0; i < n; i++) {
            if (remainingCubes > 200) {
                result[i] = 200;
                remainingCubes -= 200;
            } else {
                result[i] = remainingCubes;
                remainingCubes = 0;
            }
        }

    }
}
