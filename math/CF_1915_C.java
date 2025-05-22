package math;

import java.util.Scanner;

public class CF_1915_C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            long total = 0;
            for (int i = 0; i < n; i++) {
                long temp = input.nextLong();
                total += temp;
            }
            long sqrt = (long) Math.sqrt(total);
            if (sqrt * sqrt == total) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        input.close();
    }
}
