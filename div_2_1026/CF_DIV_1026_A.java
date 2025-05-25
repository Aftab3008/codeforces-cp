package div_2_1026;

import java.util.*;

public class CF_DIV_1026_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int[] a = new int[n];

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                max = Math.max(max, a[i]);
                min = Math.min(min, a[i]);
            }

            int fashion = max - min;

            if (fashion % 2 == 0) {
                System.out.println(0);
            } else {
                Arrays.sort(a);
                int i1 = 0;
                while (i1 < n && (a[n - 1] - a[i1]) % 2 != 0) {
                    i1++;
                }

                int j1 = n - 1;
                while (j1 >= 0 && (a[j1] - a[0]) % 2 != 0) {
                    j1--;
                }

                int minSteps = Math.min(i1, n - 1 - j1);
                System.out.println(minSteps);
            }
        }

        input.close();
    }
}
