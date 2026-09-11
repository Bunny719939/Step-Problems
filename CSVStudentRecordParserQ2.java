import java.util.Scanner;

public class CSVStudentRecordParserQ2 {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length == 3) {
            String name = fields[0];
            String rollNumber = fields[1];
            String department = fields[2];

            String result = "Name: " + name + " | Roll No: " +
                    rollNumber + " | Dept: " + department;

            System.out.println(result);
        } else {
            String result = "Invalid Record";
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String csvLine = scanner.nextLine();

        parseStudentRecord(csvLine);

        scanner.close();
    }
}
