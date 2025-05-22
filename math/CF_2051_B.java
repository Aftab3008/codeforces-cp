package math;

import java.util.Scanner;

public class CF_2051_B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();

            long cycleSum = a + b + c;
            long cycles = n / cycleSum;
            long covered = cycles * cycleSum;
            long rem = n - covered;

            long days = cycles * 3;
            if (rem > 0) {
                if (rem <= a) {
                    days += 1;
                } else if (rem <= a + b) {
                    days += 2;
                } else {
                    days += 3;
                }
            }

            System.out.println(days);
        }
        in.close();
    }
}
