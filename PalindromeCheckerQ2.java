import java.util.Scanner;

public class PalindromeCheckerQ2 {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] originalCharacters = text.toCharArray();
        char[] reversedCharacters = new char[originalCharacters.length];

        for (int index = 0; index < originalCharacters.length; index++) {
            reversedCharacters[index] =
                    originalCharacters[originalCharacters.length - 1 - index];
        }

        return new String(originalCharacters).equals(new String(reversedCharacters));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayReversalResult = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " +
                (iterativeResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (recursiveResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (arrayReversalResult ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }
}
