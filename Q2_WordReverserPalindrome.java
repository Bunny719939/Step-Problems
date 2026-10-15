import java.util.Scanner;

public class Q2_WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 2;

        while (n-- > 0) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder(s);
            String rev = sb.reverse().toString();

            if (s.equals(rev))
                System.out.println(rev + " - palindrome");
            else
                System.out.println(rev + " - not a palindrome");
        }
    }
}
