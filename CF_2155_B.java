import java.util.Scanner;
import java.util.Arrays;

/**
 * Solves the maze construction problem using Scanner.
 * The core logic is to determine the number of non-escaping cells (m = n*n -
 * k).
 * - If m = 1, it's impossible, as a non-escaping path must end in a cycle,
 * and the smallest cycle involves 2 cells.
 * - If m = 0, all cells are 'U' (escape).
 * - If m >= 2, we construct (m / 2) 2-cell cycles using 'R' and 'L'.
 * - If m is odd, we make one extra cell point into a cycle (e.g., with 'U').
 * - All other cells are set to an escaping direction ('R') to avoid
 * unintentionally feeding into our cycles.
 */
public class CF_2155_B { // Renamed class to match your stub

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Use Scanner

        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            // Solve the problem for this test case
            solve(n, k);
        }
        input.close();
    }

    public static void solve(int n, int k) {
        // m is the number of NON-escaping cells
        int m = n * n - k;

        // A single non-escaping cell is impossible.
        // Any non-escaping cell must lead to a cycle, and the minimum cycle size is 2.
        if (m == 1) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        char[][] grid = new char[n][n];

        // If m = 0 (all cells escape), fill with 'U' and return.
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(grid[i], 'U');
            }
            printGrid(grid, n);
            return;
        }

        // --- Construction for m >= 2 ---

        // We will create (m / 2) 2-cell cycles.
        // Start by filling the grid with 'R' (a default escaping direction).
        // This is safer than 'U' as our cycle-feeders might use 'U'.
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 'R');
        }

        int pairsToMake = m / 2;
        int r = 0;
        int c = 0;

        // Create (m / 2) cycles of 'R' -> 'L'
        while (pairsToMake > 0 && r < n) {
            grid[r][c] = 'R';
            grid[r][c + 1] = 'L';
            pairsToMake--;
            c += 2;
            // Move to the next row if this one is full
            if (c >= n - 1) {
                r++;
                c = 0;
            }
        }

        // If m is odd, we need one more non-escaping cell.
        // (r, c) is the next available cell.
        if (m % 2 == 1) {
            // We are at grid[r][c].
            // If c > 0, the cell (r, c-1) is 'L', part of a cycle. Point to it.
            // If c == 0, the cell (r-1, c) is part of a cycle. Point to it.
            if (c > 0) {
                grid[r][c] = 'L'; // Points to (r, c-1), which is 'L' (part of R-L cycle)
            } else {
                // We are at the start of a new row (r > 0)
                grid[r][c] = 'U'; // Points to (r-1, 0), which is 'R' (part of R-L cycle)
            }
        }

        printGrid(grid, n);
    }

    public static void printGrid(char[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
