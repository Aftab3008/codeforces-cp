package arrays;

import java.util.Scanner;

public class CF_2092_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] a = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                if (a[i] < min)
                    min = a[i];
                if (a[i] > max)
                    max = a[i];
            }
            System.out.println(max - min);
        }
        input.close();
    }
}