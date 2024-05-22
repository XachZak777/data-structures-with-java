public class Recursion {

    // Recursive Factorial (Efficiency O(n)) 
    public static int factorial (int n) throws IllegalArgumentException {
        if (n < 0) 
            throw new IllegalArgumentException(); // Must be Non-negative
        else if (n == 0) 
            return 1; // Base case
        else
            return n * factorial (n-1); // Recursive Call
    }

    // Recursive Binary Search Algorithm (Efficiency O(log n)) 
    public static boolean binarySearch (int[] data, int target, int low, int high) {
        if (low > high) // Empty interval
            return false;
        else {
            int mid = (low + high) / 2;
            if (target == data[mid]) 
                return true; // Finds a match
            else if (target < data[mid]) 
                return binarySearch(data, target, low, high-1); // Left to the mid
            else 
                return binarySearch(data, target, low-1, high); // Right to the mid
        }
    }

    // Recursive English Ruler (Efficiency O(2^n))
    public static void drawRuler (int nInches, int majorLenght) {
        drawLine(majorLenght, 0);
        for (int j = 0; j <= nInches; j++) {
            drawInterval(majorLenght - 1);
            drawLine(majorLenght, j);
        }
    }

    // Helper for English Ruler 
    private static void drawInterval (int centralLenght) {
        if (centralLenght >= 1) {
            drawInterval(centralLenght - 1);
            drawLine(centralLenght);
            drawInterval(centralLenght - 1);
        }
    }

    // Helper for English Ruler 
    private static void drawLine (int tichLenght, int tickLabel) {
        for (int j = 0; j < tichLenght; j++) 
            System.out.print("-");
        if (tickLabel >= 0) 
            System.out.print(" " + tickLabel);
        System.out.print("\n");
    }

    // Helper for English Ruler 
    private static void drawLine (int tichLenght) {
        drawLine(tichLenght, 1);
    }

    // Linear Sum of an elements of array (Efficiency O(n))
    public static int linearSum (int[] data, int n) {
        if (n == 0)
            return 0;
        else
            return linearSum(data, n-1) + data[n-1];
    }

    // Reversing a sequence (Efficiency O(n))
    public static void reverseArray (int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low+1, high-1);
        }
    }

    // Computing power (Efficiency O(n))
    public static double power (double x, int n) {
        if (n == 0) 
            return 1;
        else
            return x * power(x, n-1);
    }

    // Computing power. Faster Approach (Efficiency O(log n))
    public static double powerFast (double x, int n) {
        if (n == 0)
            return 1;
        else {
            double partial = powerFast(x, n/2);
            double result = partial * partial;
            if (n % 2 == 1) 
                result *= x;
            return result;
        }
    }

    // Sum of array elemets. Binary recursive method (Time O(n) Memory O(log n))
    public static int binarySum (int[] data, int low, int high) {
        if (low > high) 
            return 0;
        else if (low == high) 
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    // Recursive Tower of Hanoi puzzle solver (Time O(2^n) Memory O(n))
    public static void towerOfHanoi (int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from rod " + 
            from + " to rod " + to);
            return;
        }
        towerOfHanoi(n-1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + 
            from + " to rod " + to);
        towerOfHanoi(n-1, aux, to, from);
    }

    // Fibonachi numbers. Efficient Recursion (Efficiency O(n))
    public static long[] fibonachiGood (int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        }
        else {
            long[] temp = fibonachiGood(n-1); 
                                        // Returns {F(n-1), F(n-2)}
            long[] answer = {temp[0] + temp[1], temp[0]}; 
                                        // Returns {F(n), F(n-1)}
            return answer;
        }
    }

    // Binary Search Iterative.
    public static boolean binarySearchIter (int[] data, int target) {
        int low = 0;
        int high = data.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true;
            else if (target < data[mid])
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}