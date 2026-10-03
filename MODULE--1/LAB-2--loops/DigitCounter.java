// 6. Write a Java program to count the number of digits in a given integer.
import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        int count = 0;
            while (n > 0) {
                n = n / 10;
                count++;
            }
        System.out.println("Number of digits = " + count);
    }
}