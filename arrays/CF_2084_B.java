package arrays;

import java.util.Scanner;

public class CF_2084_B {

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long[] computeGCDSuffix(long[] arr) {
        int n = arr.length;
        long[] gcdSuffix = new long[n];

        gcdSuffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            gcdSuffix[i] = gcd(arr[i], gcdSuffix[i + 1]);
        }

        return gcdSuffix;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = input.nextLong();
            }

            long[] b = new long[n];
            b[0] = a[0];
            for (int i = 1; i < n; i++) {
                b[i] = Math.min(b[i - 1], a[i]);
            }

            long[] gcdSuffix = computeGCDSuffix(a);

            boolean found = false;
            for (int i = 0; i < n - 1; i++) {
                if (b[i] == gcdSuffix[i + 1]) {
                    found = true;
                    break;
                }
            }
            System.out.println(found ? "YES" : "NO");
        }
        input.close();
    }
}
