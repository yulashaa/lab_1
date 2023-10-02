import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scan.next();
        System.out.println(validateEmail(email));
    }
    public static boolean validateEmail(final String email) {
        boolean endDot = false;
        endDot = email.endsWith(".");
        int indexOfAt = email.indexOf('@');
        int lastDotIndex = email.lastIndexOf('.');
        int countOfAt = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@')
                countOfAt++;
        }

        String userName = email.substring(0, email.indexOf('@'));
        String domainName = email.substring(email.indexOf('@') + 1, email.length());
        int countOfDotAfterAt = 0;
        for (int i = 0; i < domainName.length(); i++) {
            if (domainName.charAt(i) == '.')
                countOfDotAfterAt++;
        }
        if ((countOfAt == 1) && (!userName.endsWith(".")) && (countOfDotAfterAt == 1)) {
            return true;
        } else {
            return false;
        }
    }
}
