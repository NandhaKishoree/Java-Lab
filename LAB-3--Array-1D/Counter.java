// 8. Count the Number of Even and Odd Elements in an Array
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        System.out.println("Even elements = " + evenCount);
        System.out.println("Odd elements = " + oddCount);
    }
}