package math;

import java.util.Scanner;

public class CF_2072_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int p = input.nextInt();

            k = Math.abs(k);

            int steps = k / p;
            if (k % p != 0) {
                steps++;
            }

            if (steps <= n) {
                System.out.println(steps);
            } else {
                System.out.println(-1);
            }
        }
        input.close();
    }
}
