import java.util.Scanner;

public class FileExtensionValidatorQ3 {

    static String validateFileExtension(String filename) {
        String result;
        int dotPosition = filename.lastIndexOf('.');

        if (dotPosition == -1 || dotPosition == filename.length() - 1) {
            result = "Rejected — invalid file type";
        } else {
            String extension = filename.substring(dotPosition + 1);

            if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {
                result = "Accepted";
            } else {
                result = "Rejected — invalid file type";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        String validationResult = validateFileExtension(filename);

        System.out.println(validationResult);

        scanner.close();
    }
}
