import java.util.Scanner;

public class CF_2167_G {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();

            int arr[] = new int[n];
            int cost[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }

            for (int i = 0; i < n; i++) {
                cost[i] = input.nextInt();
            }

            long result = miniDropCost(n, arr, cost);
            System.out.println(result);
        }

        input.close();
    }

    private static long miniDropCost(int n, int[] arr, int[] cost) {
        boolean isValid = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            return 0;
        }

        long[] C = new long[n + 1];
        for (int i = 0; i < n; i++) {
            C[i + 1] = C[i] + cost[i];
        }

        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            dp[i] = C[i];

            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    long costToChangeBetween = C[i] - C[j + 1];
                    dp[i] = Math.min(dp[i], dp[j] + costToChangeBetween);
                }
            }
        }

        long minTotalCost = C[n];

        for (int i = 0; i < n; i++) {
            long costToChangeAfter = C[n] - C[i + 1];
            minTotalCost = Math.min(minTotalCost, dp[i] + costToChangeAfter);
        }

        return minTotalCost;
    }
}