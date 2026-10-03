// 8. Write a Java program to multiply two matrices.
import java.util.Scanner;

public class Mul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows of the first matrix: ");
        int r1 = sc.nextInt();
        System.out.print("Enter columns of the first matrix: ");
        int c1 = sc.nextInt();
        System.out.print("Enter rows of the second matrix: ");
        int r2 = sc.nextInt();
        System.out.print("Enter columns of the second matrix: ");
        int c2 = sc.nextInt();

        if (c1 != r2) {
            System.out.println("Multiplication not possible! Columns of the first must equal rows of the second.");
            return;
        }

        int[][] first = new int[r1][c1];
        int[][] second = new int[r2][c2];
        int[][] product = new int[r1][c2];

        System.out.println("Enter elements of the first matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                first[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of the second matrix:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                second[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        System.out.println("Product of the two matrices:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }
}