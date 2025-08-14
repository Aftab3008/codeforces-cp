package math;

import java.util.Scanner;

public class CF_2030_A {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int a = input.nextInt();
                max = Math.max(max, a);
                min = Math.min(min, a);
            }
            int score = (max - min) * (n - 1);
            System.out.println(score);
        }
        input.close();
    }
}