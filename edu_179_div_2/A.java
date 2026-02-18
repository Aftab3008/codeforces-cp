package edu_179_div_2;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int x = input.nextInt();
            int k = 31 - Integer.numberOfLeadingZeros(x);
            int result = 2 * k + 3;
            System.out.println(result);
        }
        input.close();
    }
}