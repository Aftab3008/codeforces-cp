import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CF_1249_E {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int l = input.nextInt();
            int r = input.nextInt();

            int symbols[] = new int[n];

            for (int i = 0; i < n; i++) {
                symbols[i] = input.nextInt();
            }

            long atMostK = countAtMostK(symbols, n, k, l, r);
            long atMostKMinus1 = countAtMostK(symbols, n, k - 1, l, r);

            System.out.println(atMostK - atMostKMinus1);
        }

        input.close();
    }

    /**
     * Solves the sub-problem:
     * "Find the number of continuous subarrays with AT MOST k distinct numbers
     * and length between l and r (inclusive)."
     *
     * We use a sliding window approach [left, right].
     * 'right' pointer expands the window.
     * 'left' pointer shrinks the window whenever we have more than k distinct
     * elements.
     */
    private static long countAtMostK(int[] symbols, int n, int k, int l, int r) {
        if (k < 0) {
            return 0;
        }

        long totalCount = 0;
        int left = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            frequencyMap.put(symbols[right], frequencyMap.getOrDefault(symbols[right], 0) + 1);

            while (frequencyMap.size() > k) {
                frequencyMap.put(symbols[left], frequencyMap.get(symbols[left]) - 1);
                if (frequencyMap.get(symbols[left]) == 0) {
                    frequencyMap.remove(symbols[left]);
                }
                left++;
            }

            // --- At this point, the window [left, right] is valid ---
            // It has AT MOST k distinct elements.
            // Any subarray [b, right] where 'b' is between 'left' and 'right'
            // will also have at most k distinct elements.

            // --- Now, we must ALSO satisfy the length constraints ---
            // We need to count the number of valid start pointers 'b' for the
            // current end pointer 'right'.
            // A valid 'b' must satisfy:
            // 1. left <= b <= right (to satisfy the 'at most k' constraint)
            // 2. l <= (right - b + 1) <= r (to satisfy the length constraint)

            // Let's analyze the length constraint (2):
            // a) l <= right - b + 1 => b <= right - l + 1
            // b) right - b + 1 <= r => b >= right - r + 1

            // We combine all conditions for 'b':
            // - b >= left
            // - b >= right - r + 1
            // - b <= right - l + 1
            // (Note: b <= right is implied by b <= right - l + 1, since l >= 1)

            // So, the valid range for 'b' is:
            // [ max(left, right - r + 1), right - l + 1 ]

            int lowerBoundB = Math.max(left, right - r + 1);
            int upperBoundB = right - l + 1;

            // If a valid range for 'b' exists (upper >= lower),
            // we count how many such 'b's there are.
            if (upperBoundB >= lowerBoundB) {
                // The number of integers in a range [A, B] is (B - A + 1)
                totalCount += (long) (upperBoundB - lowerBoundB + 1);
            }
        }

        return totalCount;
    }
}