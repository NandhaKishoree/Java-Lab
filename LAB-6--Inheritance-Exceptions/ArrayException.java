// 10. Write a Java program that accepts an array index and performs an operation on an array. Use try-catch to handle ArrayIndexOutOfBoundsException and another appropriate exception. Use a finally block to display a message indicating that exception handling has been completed.
import java.util.Scanner;

public class ArrayException {
    public static void main(String[] args) {
        int[] arr = {10, 20, 0, 40, 50};
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an array index (0-4): ");
        int index = sc.nextInt();

        try {
            int result = 100 / arr[index];
            System.out.println("100 / arr[" + index + "] = " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index " + index + " is out of range");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        } finally {
            System.out.println("Exception handling completed");
        }
    }
}