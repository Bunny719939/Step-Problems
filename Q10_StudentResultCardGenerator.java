
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks)
            sum += mark;

        return sum / 3.0;
    }

    String calculateGrade() {
        double avg = calculateAverage();

        if (avg >= 75)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 40)
            return "D";
        else
            return "F";
    }
}

public class Q10_StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int j = 0; j < 3; j++)
                marks[j] = sc.nextInt();

            Student s = new Student(name, marks);

            System.out.printf("%s: Average %.1f, Grade %s%n",
                    s.name.toUpperCase(),
                    s.calculateAverage(),
                    s.calculateGrade());
        }
    }
}
