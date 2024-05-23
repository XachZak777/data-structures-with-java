package dsHomework1;

import java.util.Scanner;

public class Salamancas {

    // Efficiency O(n).
    // Best time O(1).
    public static void communicateWithHector(Scanner scanner) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            if (word.isEmpty()) continue;

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char correctLetter = findLetter(word.charAt(i), alphabet);
                result.append(correctLetter);
            }
            System.out.println(result.toString());
        }
    }

    private static char findLetter(char target, String alphabet) {
        for (int i = 0; i < alphabet.length(); i++) {
            char currentLetter = alphabet.charAt(i);
            if (ringBell(currentLetter, target)) {
                return currentLetter;
            }
        }
        return '-';
    }

    // Efficiency O(n)
    // Best Case O(1)
    public static void communicateWithHectorGrid(Scanner scanner) {
        char[][] grid = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'}
        };

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            if (word.isEmpty()) continue;

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char correctLetter = findLetterInGrid(word.charAt(i), grid);
                result.append(correctLetter);
            }
            System.out.println(result.toString());
        }
    }

    private static char findLetterInGrid(char target, char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            if (containsLetterInRow(target, grid[row])) {
                for (char letter : grid[row]) {
                    if (ringBell(letter, target)) {
                        return letter;
                    }
                }
            }
        }
        return '-';
    }

    private static boolean containsLetterInRow(char target, char[] row) {
        for (char letter : row) {
            if (letter == target) {
                return true;
            }
        }
        return false;
    }

    private static boolean ringBell(char currentLetter, char target) {
        return currentLetter == target;
    }

    // Efficiency O(n)
    // Best Case O(1)
    public static void communicateWithEduardo(Scanner scanner) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        while (scanner.hasNextLine()) {
            int wordLength = Integer.parseInt(scanner.nextLine().trim());
            if (wordLength == 0) continue;

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < wordLength; i++) {
                char correctLetter = findLetterEduardo(scanner, alphabet);
                result.append(correctLetter);
            }
            System.out.println(result.toString());
        }
    }

    private static char findLetterEduardo(Scanner scanner, String alphabet) {
        for (int i = 0; i < alphabet.length(); i++) {
            char currentLetter = alphabet.charAt(i);
            int response = Integer.parseInt(scanner.nextLine().trim());
            if (response == 1) {
                return currentLetter;
            }
        }
        return '-';
    }

}