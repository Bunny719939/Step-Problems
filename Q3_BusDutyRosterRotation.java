
import java.util.Scanner;
import java.util.Arrays;

public class Q3_BusDutyRosterRotation {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        long k = sc.nextLong();

        System.out.println(Arrays.toString(rotateRoster(names, k)));
    }
}
