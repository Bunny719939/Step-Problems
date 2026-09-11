import java.util.Scanner;

public class ReverseCustomerNameQ5 {

    static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();

        for (int i = 0; i < characters.length / 2; i++) {
            char temporary = characters[i];
            characters[i] = characters[characters.length - 1 - i];
            characters[characters.length - 1 - i] = temporary;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}
