package math;

import java.util.Scanner;

public class CF_2057_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            long n = input.nextLong();
            long m = input.nextLong();
            System.out.println(Math.max(n, m) + 1);
        }
        input.close();
    }
}
