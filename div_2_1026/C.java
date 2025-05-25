package div_2_1026;

import java.util.Scanner;

// Wrong Answer

public class C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int[] d = new int[n];

            for (int i = 0; i < n; i++) {
                d[i] = input.nextInt();
            }

            int[][] range = new int[n][2];
            for (int i = 0; i < n; i++) {
                range[i][0] = input.nextInt();
                range[i][1] = input.nextInt();
            }

            int h = 0;
            int change = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if (d[i] != -1) {
                    h += d[i];
                } else {
                    change++;
                    int lb = range[i][0] - h;
                    int ub = range[i][1] - h;

                    if (lb > ub || ub < 0 || lb > 1) {
                        valid = false;
                        break;
                    }

                    if (ub >= 1) {
                        d[i] = 1;
                    } else {
                        d[i] = 0;
                    }

                    h += d[i];
                }
            }

            if (!valid || change == 0) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(d[i] + " ");
                }
                System.out.println();
            }
        }

        input.close();
    }
}
