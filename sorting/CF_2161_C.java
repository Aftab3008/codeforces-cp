package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CF_2161_C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            long X = input.nextLong();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }

            getMaxBonus(arr, n, X);
        }

        input.close();
    }

    private static void getMaxBonus(int[] arr, int n, long x) {
        ArrayList<Integer> order = new ArrayList<>();
        long bonus = 0;
        long s = 0;

        Arrays.sort(arr);

        int i = 0;
        int j = n - 1;

        while (i <= j) {
            long level = s / x;
            long nextLevel = (level + 1) * x;

            if (s + arr[j] >= nextLevel) {
                s += arr[j];
                bonus += arr[j];
                order.add(arr[j]);
                j--;
            } else {
                s += arr[i];
                if (s >= nextLevel) {
                    bonus += arr[i];
                }
                order.add(arr[i]);
                i++;
            }
        }

        System.out.println(bonus);

        if (order.size() > 0) {
            for (int or : order) {
                System.out.print(or + " ");
            }
            System.out.println();
        }
    }
}