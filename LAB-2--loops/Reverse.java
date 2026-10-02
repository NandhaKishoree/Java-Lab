// 4. Write a Java program to reverse the digits of a given integer.
import java.util.Scanner;

public class Reverse{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        int temp = n;
        int reversed = 0;
        while (temp > 0) {
            int num = temp % 10;
            reversed = reversed * 10 + num;
            temp = temp / 10;
        }
        System.out.println("Reversed number = " + reversed);
    }
}