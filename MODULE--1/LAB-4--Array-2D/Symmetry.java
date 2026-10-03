
import java.util.Scanner;

class Symmetry {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row no : ");
        int r = sc.nextInt();
        System.out.print("Enter the column no : ");
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Enter matrix elements");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("[" + arr[i][j] + "]");
            }
            System.out.println();
        }
        boolean sym = true;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != arr[j][i]) {
                    sym = false;
                    break;
                }
            }

            if (!sym) {
                break;

            }
        }
        if (sym) {
            System.out.println("Symmetric matrix");
        } else {
            System.out.println("Not symmetric matrix");
        }

    }

}
