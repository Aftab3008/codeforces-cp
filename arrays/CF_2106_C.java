package arrays;

import java.util.Scanner;

public class CF_2106_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            int[] a = new int[n];
            int[] b = new int[n];
            int countMising = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
                if (b[i] == -1)
                    countMising++;
            }
            long x = -1;
            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                if (b[i] != -1) {
                    long sum = (long) a[i] + b[i];
                    if (x == -1)
                        x = sum;
                    else if (sum != x) {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (!isPossible) {
                System.out.println(0);
                continue;
            }
            if (countMising == n) {
                long lo = Long.MIN_VALUE, hi = Long.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    lo = Math.max(lo, a[i]);
                    hi = Math.min(hi, a[i] + k);
                }
                long ways = lo <= hi ? hi - lo + 1 : 0;
                System.out.println(ways);
            } else {
                for (int i = 0; i < n; i++) {
                    if (b[i] == -1) {
                        long bi = x - a[i];
                        if (bi < 0 || bi > k) {
                            isPossible = false;
                            break;
                        }
                    }
                }
                System.out.println(isPossible ? 1 : 0);
            }
        }
        scanner.close();
    }
}
