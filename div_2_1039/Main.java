package div_2_1039;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = in.nextInt();
            int l = 0, r = n - 1;
            StringBuilder sb = new StringBuilder(n);
            int[] last4 = new int[4];
            int cnt = 0;
            while (l <= r) {
                int xL = p[l], xR = p[r];
                boolean okL = isSafe(last4, cnt, xL);
                boolean okR = isSafe(last4, cnt, xR);
                if (okL) {
                    sb.append('L');
                    add(last4, cnt, xL);
                    if (cnt < 4)
                        cnt++;
                    l++;
                } else {
                    sb.append('R');
                    add(last4, cnt, xR);
                    if (cnt < 4)
                        cnt++;
                    r--;
                }
            }
            System.out.println(sb);
        }
        in.close();
    }

    static boolean isSafe(int[] last4, int cnt, int x) {
        if (cnt < 4)
            return true;
        int[] a = new int[5];
        for (int i = 0; i < 4; i++)
            a[i] = last4[i];
        a[4] = x;
        boolean inc = true, dec = true;
        for (int i = 0; i < 4; i++) {
            if (!(a[i] < a[i + 1]))
                inc = false;
            if (!(a[i] > a[i + 1]))
                dec = false;
        }
        return !(inc || dec);
    }

    static void add(int[] last4, int cnt, int x) {
        if (cnt < 4) {
            last4[cnt] = x;
        } else {
            last4[0] = last4[1];
            last4[1] = last4[2];
            last4[2] = last4[3];
            last4[3] = x;
        }
    }
}
