import java.util.Scanner;

abstract class Ticket {
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double calculatePrice();

    double calculateTotal() {
        return calculatePrice() + 20 * count;
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double calculatePrice() {
        return 150 * count;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double calculatePrice() {
        return 250 * count;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double calculatePrice() {
        return 400 * count;
    }
}

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            if (type.equals("REGULAR")) {
                ticket = new Regular(count);
            } else if (type.equals("PREMIUM")) {
                ticket = new Premium(count);
            } else {
                ticket = new Recliner(count);
            }

            double amount = ticket.calculateTotal();

            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
