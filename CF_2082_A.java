import java.util.Scanner;

public class CF_2082_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = input.next();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                }
            }

            int[] rowXOR = new int[n];
            int[] colXOR = new int[m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rowXOR[i] ^= arr[i][j];
                    colXOR[j] ^= arr[i][j];
                }
            }

            int a = 0, b = 0;
            for (int xor : rowXOR) {
                a += xor;
            }
            for (int xor : colXOR) {
                b += xor;
            }

            System.out.println(Math.max(a, b));
        }
        input.close();
    }
}