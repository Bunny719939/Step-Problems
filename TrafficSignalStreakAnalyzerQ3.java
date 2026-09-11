import java.util.Scanner;

public class TrafficSignalStreakAnalyzerQ3 {

    static void findLongestStreak(String signalLog) {
        int currentStreakLength = 1;
        int longestStreakLength = 1;
        char longestStreakColor = signalLog.charAt(0);

        for (int index = 1; index < signalLog.length(); index++) {
            if (signalLog.charAt(index) == signalLog.charAt(index - 1)) {
                currentStreakLength++;
            } else {
                currentStreakLength = 1;
            }

            if (currentStreakLength > longestStreakLength) {
                longestStreakLength = currentStreakLength;
                longestStreakColor = signalLog.charAt(index);
            }
        }

        System.out.println("Longest Streak: '" + longestStreakColor +
                "' repeated " + longestStreakLength + " times");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String signalLog = scanner.nextLine();

        if (!signalLog.isEmpty()) {
            findLongestStreak(signalLog);
        } else {
            System.out.println("Invalid input. Signal log cannot be empty.");
        }

        scanner.close();
    }
}
