package math;

import java.util.Scanner;

public class CF_2102_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int p = input.nextInt();
            int q = input.nextInt();
            if (n % p != 0 || m == (n / p) * q) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        input.close();
    }
}
