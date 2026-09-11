import java.util.Scanner;

public class ShortestLongestWordFinderQ5 {

    static String[] findShortestAndLongestWord(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = cleanedText.trim().split("\\s+");

        String shortestWord = words[0];
        String longestWord = words[0];

        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }

            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return new String[]{shortestWord, longestWord};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = scanner.nextLine();

        String[] results = findShortestAndLongestWord(text);

        String shortestWord = results[0];
        String longestWord = results[1];

        System.out.println("Shortest: \"" + shortestWord +
                "\" (" + shortestWord.length() + ")");

        System.out.println("Longest: \"" + longestWord +
                "\" (" + longestWord.length() + ")");

        scanner.close();
    }
}
