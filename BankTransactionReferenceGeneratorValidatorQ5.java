import java.util.Scanner;

public class BankTransactionReferenceGeneratorValidatorQ5 {

    static String normalizeReference(String raw) {
        String trimmedReference = raw.trim();

        if (trimmedReference.length() < 3) {
            return trimmedReference;
        }

        String bankCode = trimmedReference.substring(0, 3).toUpperCase();
        String remainingPart = trimmedReference.substring(3);

        return bankCode + remainingPart;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int index = 3; index < reference.length(); index++) {
            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        String formattedDate = date.substring(0, 2) + "/" +
                date.substring(2, 4) + "/" +
                date.substring(4, 6);

        StringBuilder formattedReference = new StringBuilder();
        formattedReference.append("[");
        formattedReference.append(bankCode);
        formattedReference.append("] DATE: ");
        formattedReference.append(formattedDate);
        formattedReference.append(" | SEQ: ");
        formattedReference.append(sequence);

        return formattedReference.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawReference = scanner.nextLine();

        String normalizedReference = normalizeReference(rawReference);

        if (normalizedReference.length() < 3) {
            System.out.println("Invalid: wrong length");
        } else {
            String result = validateAndFormat(normalizedReference);
            System.out.println(result);
        }

        scanner.close();
    }
}
