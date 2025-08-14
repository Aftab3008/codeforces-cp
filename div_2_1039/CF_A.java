package div_2_1039;

import java.util.*;

public class CF_A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt(), c = in.nextInt();
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            Arrays.sort(a);
            int coins = 0;
            for (int s = 0; s < n; s++) {
                long T = c / (1L << s);
                int idx = upperBound(a, T, n - s) - 1;
                if (idx >= 0) {
                    System.arraycopy(a, idx + 1, a, idx, n - s - idx - 1);
                } else {
                    coins++;
                }
            }
            System.out.println(coins);
        }
        in.close();
    }

    static int upperBound(Integer[] a, long key, int len) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= key)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
