// 9. Find Duplicate Elements in an Array
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] checked = new boolean[n];
        boolean found = false;

        System.out.println("Duplicate elements:");
        for (int i = 0; i < n; i++) {
            if (checked[i]) 
            continue;

            boolean duplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = true;
                    checked[j] = true;
                }
            }
            if (duplicate) {
                System.out.print(arr[i] + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No duplicates found");
        }
    }
}