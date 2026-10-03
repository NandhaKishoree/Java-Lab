// 4. Write a Java program to calculate the sum of each row in a arr.
import java.util.Scanner;

public class RowSum {
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

        for (int i = 0; i < r; i++) {
            int rum = 0;
            for (int j = 0; j < c; j++) {
                rum += arr[i][j];
            }
            System.out.println("Sum of row " + (i + 1) + " = " + rum);
        }
    }
}