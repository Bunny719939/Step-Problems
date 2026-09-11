import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StopWordFilteredWordFrequencyReportQ5 {

    static void printFilteredWordFrequency(String feedback) {
        String cleanedText = feedback.toLowerCase();
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        String[] words = cleanedText.split("\\s+");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        String[] uniqueWords = frequencyMap.keySet().toArray(new String[0]);

        for (int i = 0; i < uniqueWords.length - 1; i++) {
            for (int j = i + 1; j < uniqueWords.length; j++) {
                if (frequencyMap.get(uniqueWords[j]) > frequencyMap.get(uniqueWords[i])) {
                    String temp = uniqueWords[i];
                    uniqueWords[i] = uniqueWords[j];
                    uniqueWords[j] = temp;
                }
            }
        }

        for (String word : uniqueWords) {
            System.out.println(word + ": " + frequencyMap.get(word));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
