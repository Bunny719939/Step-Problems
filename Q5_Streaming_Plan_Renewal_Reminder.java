import java.util.Scanner;

abstract class Plan {
    String name;
    int year;
    int month;
    int day;

    Plan(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    abstract int getDays();

    void calculateRenewal() {
        int days = getDays();

        while (days > 0) {
            int daysInMonth;

            if (month == 2) {
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                daysInMonth = 30;
            } else {
                daysInMonth = 31;
            }

            int remainingDays = daysInMonth - day;

            if (days <= remainingDays) {
                day += days;
                days = 0;
            } else {
                days -= remainingDays + 1;
                day = 1;

                if (month == 12) {
                    month = 1;
                    year++;
                } else {
                    month++;
                }
            }
        }
    }

    void display() {
        System.out.printf("%s: %04d-%02d-%02d%n", name, year, month, day);
    }
}

class Basic extends Plan {
    Basic(String name, int year, int month, int day) {
        super(name, year, month, day);
    }

    int getDays() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, int year, int month, int day) {
        super(name, year, month, day);
    }

    int getDays() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, int year, int month, int day) {
        super(name, year, month, day);
    }

    int getDays() {
        return 365;
    }
}

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new Basic(name, year, month, day);
            } else if (type.equals("STANDARD")) {
                plan = new Standard(name, year, month, day);
            } else {
                plan = new Premium(name, year, month, day);
            }

            plan.calculateRenewal();
            plan.display();
        }
    }
}
