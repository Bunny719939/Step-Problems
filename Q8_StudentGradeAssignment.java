
import java.util.Scanner;

public class Q8_StudentGradeAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int marks = sc.nextInt();

            if (marks >= 90)
                System.out.println("Grade A");
            else if (marks >= 75)
                System.out.println("Grade B");
            else if (marks >= 60)
                System.out.println("Grade C");
            else if (marks >= 40)
                System.out.println("Grade D");
            else
                System.out.println("Grade F");
        }
    }
}
