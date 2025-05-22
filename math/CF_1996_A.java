package math;

import java.util.Scanner;

public class CF_1996_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int cow = n / 4;
            int rem = n % 4;
            int chicken = rem / 2;
            int total = cow + chicken;
            System.out.println(total);
        }
        input.close();
    }
}
