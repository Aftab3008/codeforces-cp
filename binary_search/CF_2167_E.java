package binary_search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class CF_2167_E {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            long x = input.nextLong();

            int position[] = new int[n];

            for (int i = 0; i < n; i++) {
                position[i] = input.nextInt();
            }

            findTeleports(position, n, k, x);
        }
        input.close();
    }

    /**
     * Finds and prints the k optimal teleport positions.
     */
    private static void findTeleports(int position[], int n, int k, long x) {
        Arrays.sort(position);

        long low = 0;
        long high = x;
        long ansD = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(position, n, k, x, mid)) {
                ansD = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Now we have the optimal distance 'ansD'.
        // We need to find and print the first k allowed positions.

        // 1. Find the forbidden intervals for this optimal distance
        List<long[]> intervals = new ArrayList<>();
        for (int pos : position) {
            // Forbidden interval is [pos - d + 1, pos + d - 1]
            long l = Math.max(0, (long) pos - ansD + 1);
            long r = Math.min(x, (long) pos + ansD - 1);
            if (l <= r) { // Add only if the interval is valid
                intervals.add(new long[] { l, r });
            }
        }

        if (intervals.isEmpty()) {
            // No forbidden intervals, just print 0, 1, ..., k-1
            for (int i = 0; i < k; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // 2. Sort and merge the forbidden intervals
        intervals.sort(Comparator.comparingLong(a -> a[0]));

        List<long[]> merged = new ArrayList<>();
        long currentL = intervals.get(0)[0];
        long currentR = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            long nextL = intervals.get(i)[0];
            long nextR = intervals.get(i)[1];

            if (nextL <= currentR + 1) { // Overlap or contiguous
                currentR = Math.max(currentR, nextR);
            } else { // Gap
                merged.add(new long[] { currentL, currentR });
                currentL = nextL;
                currentR = nextR;
            }
        }
        merged.add(new long[] { currentL, currentR });

        // 3. Iterate through the allowed gaps and print k positions
        int count = 0;
        long currentPos = 0; // Start checking from position 0
        StringBuilder sb = new StringBuilder();

        for (long[] interval : merged) {
            long forbiddenL = interval[0];
            long forbiddenR = interval[1];

            // Print from the allowed interval [currentPos, forbiddenL - 1]
            while (currentPos < forbiddenL && count < k) {
                sb.append(currentPos).append(" ");
                count++;
                currentPos++;
            }

            if (count == k)
                break;

            // Skip the forbidden interval
            currentPos = forbiddenR + 1;
        }

        // Print from the last allowed interval [currentPos, x]
        while (count < k && currentPos <= x) {
            sb.append(currentPos).append(" ");
            count++;
            currentPos++;
        }

        System.out.println(sb.toString().trim());
    }

    private static boolean check(int[] position, int n, int k, long x, long d) {
        // If d=0, the condition is |a_i - t_j| >= 0, which is always true.
        // The "forbidden" interval [a_i+1, a_i-1] is empty.
        // So, all x+1 positions are allowed.
        if (d == 0) {
            return (x + 1) >= k;
        }

        // 1. Create forbidden intervals
        List<long[]> intervals = new ArrayList<>();
        for (int pos : position) {
            // Any teleport t in [pos - d + 1, pos + d - 1] is "forbidden"
            // because |pos - t| < d
            long l = Math.max(0, (long) pos - d + 1);
            long r = Math.min(x, (long) pos + d - 1);
            if (l <= r) {
                intervals.add(new long[] { l, r });
            }
        }

        if (intervals.isEmpty()) {
            return (x + 1) >= k; // All positions are allowed
        }

        // 2. Sort and merge intervals
        intervals.sort(Comparator.comparingLong(a -> a[0]));

        long forbiddenCount = 0;
        long currentL = intervals.get(0)[0];
        long currentR = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            long nextL = intervals.get(i)[0];
            long nextR = intervals.get(i)[1];

            if (nextL <= currentR + 1) { // Overlap or contiguous
                currentR = Math.max(currentR, nextR);
            } else { // Gap
                // Add the count for the previous merged interval
                forbiddenCount += (currentR - currentL + 1);
                currentL = nextL;
                currentR = nextR;
            }
        }
        // Add the count for the last merged interval
        forbiddenCount += (currentR - currentL + 1);

        // 3. Count allowed positions
        long allowedCount = (x + 1) - forbiddenCount;
        return allowedCount >= k;
    }
}