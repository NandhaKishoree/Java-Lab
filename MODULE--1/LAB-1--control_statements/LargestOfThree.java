// 4. Write a Java program to find the largest of three numbers using nested if-else.
import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a >= b) {
            if (a >= c)
                System.out.println(a + " is the largest");
            else
                System.out.println(c + " is the largest");
        } else {
            if (b >= c)
                System.out.println(b + " is the largest");
            else
                System.out.println(c + " is the largest");
        }
    }
}