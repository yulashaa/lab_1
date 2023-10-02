import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        String[] programmingLanguages = {"Java", "KOtlIn", "JavAScripT", "GO", "Python"};
        String temp;
        for ( int i = 0; i < programmingLanguages.length - 1; i++ ) {
            for (int j = 0; j < programmingLanguages.length - i - 1; j++){
                if (CounterUpper(programmingLanguages[j]) > CounterUpper(programmingLanguages[j + 1])){
                    temp = programmingLanguages[j];
                    programmingLanguages[j] = programmingLanguages[j+1];
                    programmingLanguages[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < programmingLanguages.length; i++) {
            System.out.print(programmingLanguages[i] + " ");
        }
    }
     static int CounterUpper(final String currentString){
        int count = 0;
         for (int i = 0; i < currentString.length(); i++) {
             char ch = currentString.charAt(i);
             if (Character.isUpperCase(ch)) {
                 count++;
             }
         }
         return count;


    }
}