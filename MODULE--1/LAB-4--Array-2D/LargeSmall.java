// 3. Write a Java program to find the largest and smallest elements in a 2D array.
import java.util.Scanner;

public class LargeSmall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of r: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];
        System.out.println("Enter elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int largest = arr[0][0];
        int smallest = arr[0][0];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > largest) largest = arr[i][j];
                if (arr[i][j] < smallest) smallest = arr[i][j];
            }
        }
        System.out.println("Largest element = " + largest);
        System.out.println("Smallest element = " + smallest);
    }
}