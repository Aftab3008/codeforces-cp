package math;

import java.util.Scanner;

public class CF_2086_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            System.out.println(2 * n);
        }
        input.close();
    }
}
