package edu_179_div_2;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }

            long answer = Long.MAX_VALUE;
            int[] lenPref = new int[n];
            lenPref[0] = 0;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] == a[i]) {
                    lenPref[i] = lenPref[i - 1] + 1;
                } else {
                    lenPref[i] = 0;
                }
            }

            for (int i = 0; i < n; i++) {
                long cost = (long) a[i] * (n - lenPref[i] - 1);
                if (cost < answer) {
                    answer = cost;
                }
            }

            System.out.println(answer);
        }
        input.close();
    }
}
