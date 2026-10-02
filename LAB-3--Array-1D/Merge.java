// 10. Merge Two One-Dimensional Arrays
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int n1 = sc.nextInt();
        int[] first = new int[n1];
        System.out.println("Enter " + n1 + " elements:");
        for (int i = 0; i < n1; i++) {
            first[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int n2 = sc.nextInt();
        int[] second = new int[n2];
        System.out.println("Enter " + n2 + " elements:");
        for (int i = 0; i < n2; i++) {
            second[i] = sc.nextInt();
        }

        int[] merged = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            merged[i] = first[i];
        }
        for (int i = 0; i < n2; i++) {
            merged[n1 + i] = second[i];
        }

        System.out.println("Merged array:");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }
    }
}