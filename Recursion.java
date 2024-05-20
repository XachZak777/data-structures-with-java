public class Recursion {

    public static int factorial (int n) throws IllegalArgumentException {
        if (n < 0) 
            throw new IllegalArgumentException(); // Must be Non-negative
        else if (n == 0) 
            return 1; // Base case
        else
            return n * factorial (n-1); // Recursive Call
    }

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

    public static void drawRuler (int nInches, int majorLenght) {
        drawLine(majorLenght, 0);
        for (int j = 0; j <= nInches; j++) {
            drawInterval(majorLenght - 1);
            drawLine(majorLenght, j);
        }
    }

    private static void drawInterval (int centralLenght) {
        if (centralLenght >= 1) {
            drawInterval(centralLenght - 1);
            drawLine(centralLenght);
            drawInterval(centralLenght - 1);
        }
    }

    private static void drawLine (int tichLenght, int tickLabel) {
        for (int j = 0; j < tichLenght; j++) 
            System.out.print("-");
        if (tickLabel >= 0) 
            System.out.print(" " + tickLabel);
        System.out.print("\n");
    }

    private static void drawLine (int tichLenght) {
        drawLine(tichLenght, 1)
    }
}