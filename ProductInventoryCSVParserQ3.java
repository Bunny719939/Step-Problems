import java.util.Scanner;

public class ProductInventoryCSVParserQ3 {

    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length == 3) {
            String productName = fields[0];
            String sku = fields[1];
            String quantity = fields[2];

            System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String csvLine = scanner.nextLine();

        parseInventoryRecord(csvLine);

        scanner.close();
    }
}
