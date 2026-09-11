import java.util.Scanner;

public class MovieReviewWordLengthProfilerQ5 {

    static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");

            if (word.length() >= 1 && word.length() <= 4) {
                shortWords++;
            } else if (word.length() >= 5 && word.length() <= 8) {
                mediumWords++;
            } else if (word.length() >= 9) {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);

        sc.close();
    }
}
