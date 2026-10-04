import java.util.Scanner;

interface NightService {
    double getNightFare();
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateBaseFare();

    double calculateFare() {
        double fare = calculateBaseFare();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 14;
    }

    public double getNightFare() {
        return calculateFare() * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 18;
    }

    public double getNightFare() {
        return calculateFare() * 1.20;
    }
}

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") && type.equals("MINI")) {
                System.out.println("MINI: night service not available");
            } else {
                double fare = cab.calculateFare();

                if (time.equals("NIGHT")) {
                    if (cab instanceof Sedan) {
                        fare = ((Sedan) cab).getNightFare();
                    } else {
                        fare = ((SUV) cab).getNightFare();
                    }
                }

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
