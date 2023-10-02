import java.util.Scanner;

public class Task1 {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter first value: ");
        double firstValue = scan.nextDouble();
        System.out.print("Enter second value: ");
        double secondValue = scan.nextDouble();
        System.out.println("Answer: " + Calculator(firstValue, secondValue));
    }
    private static double Calculator (double firstValue, double secondValue) {

        System.out.print("Enter needed action (+, -, *, /): ");
        char c = scan.next().charAt(0);

        switch(c){
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case '*':
                return firstValue * secondValue;
            case '/':
                if (secondValue == 0){
                    System.out.println("Second value shouldn't be zero");
                    System.out.print("Enter second value: ");
                    secondValue = scan.nextDouble();
                    return firstValue / secondValue;
                } else {
                    return firstValue / secondValue;
                }
            default:
                System.out.println("Enter correct action!");
                Calculator(firstValue, secondValue);

        }
        return 0;
    }
}