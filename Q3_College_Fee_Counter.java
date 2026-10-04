import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateTotalFee() {
        return calculateTuition();
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    public double getTransportFee() {
        return 12000;
    }

    double calculateTotalFee() {
        return calculateTuition() + getTransportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    double calculateTotalFee() {
        return calculateTuition() + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    public double getTransportFee() {
        return 12000;
    }

    double calculateTotalFee() {
        return calculateTuition() + getTransportFee();
    }
}

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }

            double fee = student.calculateTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}
