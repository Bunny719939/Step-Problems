import java.util.Scanner;

public class TypingSpeedAccuracyCheckerQ2 {

    static void checkTypingAccuracy(String original, String typed) {
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int index = 0; index < original.length(); index++) {
            if (original.charAt(index) == typed.charAt(index)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = index;
            }
        }

        int totalCharacters = original.length();
        double accuracyPercentage = ((double) matchedCharacters / totalCharacters) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, totalCharacters, accuracyPercentage);

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " +
                    (firstMismatchPosition + 1) + " ('" +
                    original.charAt(firstMismatchPosition) + "' vs '" +
                    typed.charAt(firstMismatchPosition) + "')");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String originalPassage = scanner.nextLine();
        String typedText = scanner.nextLine();

        if (originalPassage.length() == typedText.length() &&
                originalPassage.length() > 0) {
            checkTypingAccuracy(originalPassage, typedText);
        } else {
            System.out.println("Invalid input. Strings must have equal non-zero length.");
        }

        scanner.close();
    }
}
