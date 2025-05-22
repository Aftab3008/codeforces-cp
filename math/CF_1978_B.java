package math;

import java.util.Scanner;

public class CF_1978_B {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            long n = input.nextLong();
            long a = input.nextLong();
            long b = input.nextLong();
            long k = (b > a) ? Math.min(n, b - a) : 0;
            if (b <= a) {
                System.out.println(n * a);
            } else {
                long promo = k * b - (k * (k - 1)) / 2;
                long regular = (n - k) * a;
                System.out.println(promo + regular);
            }
        }
        input.close();
    }
}