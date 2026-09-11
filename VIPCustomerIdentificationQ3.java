import java.util.Scanner;

public class VIPCustomerIdentificationQ3 {

    static String validateCustomerId(String customerId) {
        String customerType;

        if (customerId.startsWith("VIP-")) {
            customerType = "VIP Customer";
        } else {
            customerType = "Regular Customer";
        }

        return customerType;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        String customerType = validateCustomerId(customerId);

        System.out.println(customerType);

        scanner.close();
    }
}
