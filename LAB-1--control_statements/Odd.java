// 2. Write a Java program to determine whether a given number is even or odd.
import java.util.Scanner;

public class Odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}