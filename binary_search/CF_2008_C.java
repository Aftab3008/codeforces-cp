package binary_search;

import java.util.Scanner;

public class CF_2008_C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int l = input.nextInt();
            int r = input.nextInt();
            int left = 0;
            int right = r - l + 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (isPossible(mid, l, r)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(right);
        }
        input.close();
    }

    private static boolean isPossible(int n, int l, int r) {
        long temp = (long) n * (n - 1) / 2;
        long last = (long) l + temp;
        return last <= r;
    }
}
