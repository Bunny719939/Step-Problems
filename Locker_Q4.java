class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }

        return false;
    }
}

public class Locker_Q4 {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        System.out.println("First change: " + l.changeCode("1234", "5678"));
        System.out.println("Second change: " + l.changeCode("0000", "9999"));
    }
}
