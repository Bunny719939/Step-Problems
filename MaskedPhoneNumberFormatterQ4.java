import java.util.Scanner;

public class MaskedPhoneNumberFormatterQ4 {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int index = 0; index < phone.length(); index++) {
            if (!Character.isDigit(phone.charAt(index))) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits = phone.substring(6);
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");
        maskedNumber.append(lastFourDigits);
        maskedNumber.insert(6, "-");

        return maskedNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phone = scanner.nextLine();

        String result = maskPhoneNumber(phone);

        System.out.println(result);

        scanner.close();
    }
}
