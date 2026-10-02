// 5. Write a Java program to check whether a given number is a palindrome.
import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int temp = n;
        int reversed = 0;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp = temp / 10;
        }

        if (n >= 0 && n == reversed)
            System.out.println(n + " is a palindrome");
        else
            System.out.println(n + " is not a palindrome");
    }
}