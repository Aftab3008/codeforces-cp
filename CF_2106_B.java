import java.util.Scanner;

public class CF_2106_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            if (x == n) {
                for (int i = 0; i < n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                continue;
            }
            int[] arr = new int[n];
            arr[n - 1] = x;
            int num = 0;
            for (int i = 0; i < n - 1; i++) {
                if (num == x) {
                    num++;
                }
                arr[i] = num;
                num++;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + (i + 1 < n ? " " : ""));
            }
            System.out.println();
        }
        scanner.close();
    }
}
