import java.util.Scanner;

public class BMICalculatorForTeamQ3 {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-12s %-12s %-12s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-10d %-12.2f %-12.2f %-12.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int numberOfPeople = scanner.nextInt();

        double[] heights = new double[numberOfPeople];
        double[] weights = new double[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.print("Enter height for Person " + (i + 1) + " (m): ");
            heights[i] = scanner.nextDouble();

            System.out.print("Enter weight for Person " + (i + 1) + " (kg): ");
            weights[i] = scanner.nextDouble();
        }

        printWellnessReport(heights, weights);

        scanner.close();
    }
}
