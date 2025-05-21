package math;

import java.util.Scanner;

public class CF_2090_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int x = input.nextInt();
            int y = input.nextInt();
            int a = input.nextInt();
            double depth = a + 0.5;

            // Calculate how many full rounds (each round = B + K)
            int rounds = (int) (depth / (x + y));

            double totalDug = rounds * (x + y);

            // Check who digs on the next day
            if (totalDug + x >= depth) {
                System.out.println("NO"); // Little B digs and completes
            } else {
                System.out.println("YES"); // Little K completes
            }
        }
        input.close();
    }
}
