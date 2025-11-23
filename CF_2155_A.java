import java.util.Scanner;

/**
 * Main class to solve the tournament problem.
 * The solution is based on the insight that the total number of matches
 * is equal to the total number of losses required to get a single winner
 * in this modified double-elimination format.
 *
 * Each team, except the winner, must lose twice (once in winners',
 * once in losers'), OR be the W-winner who loses the final (1 loss),
 * in which case the L-winner wins (1 loss).
 *
 * In all cases, the total number of losses is (n-1) * 2 = 2n - 2.
 * Since 1 match = 1 loss, Total Matches = 2n - 2.
 */
public class CF_2155_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            // Calculate the total number of matches
            // Total matches = 2 * n - 2
            int totalMatches = 2 * n - 2;

            System.out.println(totalMatches);
        }
        sc.close();
    }
}