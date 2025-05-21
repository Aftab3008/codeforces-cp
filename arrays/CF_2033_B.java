package arrays;

import java.util.Scanner;

public class CF_2033_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }

            int result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = i, y = j;
                    int minVal = Integer.MAX_VALUE;

                    while (x < n && y < n) {
                        minVal = Math.min(minVal, a[x][y]);
                        x++;
                        y++;
                    }

                    if (minVal < 0) {
                        result += -minVal;
                        x = i;
                        y = j;
                        while (x < n && y < n) {
                            a[x][y] += -minVal;
                            x++;
                            y++;
                        }
                    }
                }
            }

            System.out.println(result);
        }

        scanner.close();
    }
}
