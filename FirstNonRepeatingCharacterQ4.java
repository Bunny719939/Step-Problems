import java.util.Scanner;

public class FirstNonRepeatingCharacterQ4 {

    static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];

        for (int index = 0; index < text.length(); index++) {
            frequency[text.charAt(index)]++;
        }

        for (int index = 0; index < text.length(); index++) {
            if (frequency[text.charAt(index)] == 1) {
                return text.charAt(index);
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }

        scanner.close();
    }
}
