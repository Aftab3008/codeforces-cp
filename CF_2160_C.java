import java.util.Scanner;

/**
 * Solves the problem: "Find if x exists such that x XOR f(x) = n"
 * where f(x) is the binary reverse of x without leading zeros.
 *
 * The logic is based on checking all possible bit-lengths L for x.
 * For a given length L (where x's (L-1)th bit is 1), the
 * XOR operation x ^ f(x) = n has special properties:
 * 1. n_i == n_(L-1-i) (n must be a palindrome within L bits)
 * 2. If L is odd, the middle bit n_(L/2) must be 0.
 * 3. All bits of n higher than L-1 must be 0.
 */

// TODO:Not done
public class CF_2160_C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            if (solve(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        input.close();
    }

    /**
     * Checks if a valid x exists for the given n.
     */
    private static boolean solve(int n) {
        // Base case: n=0.
        // x=1 is a positive integer.
        // f(1) = 1.
        // 1 ^ 1 = 0. So, YES.
        if (n == 0)
            return true;

        // Iterate through all possible bit-lengths length for x.
        // We can stop at 31 since n < 2^30.
        for (int length = 1; length <= 31; length++) {

            // Rule 3: Check if n has any bits set beyond length-1.
            // If it does, x or f(x) would need to be longer than length,
            // which contradicts our assumption for this loop.
            if ((n >> length) > 0) {
                continue;
            }

            // This is one candidate for x. We build it as we go.
            // We force x to have length, so its (length-1)th bit must be 1.
            int x = (1 << (length - 1));
            boolean possible = true;

            // Check the palindrome property (Rule 1)
            // We iterate from the outside bits (0 and length-1) inward.
            for (int i = 0; i < length / 2; i++) {
                int j = length - 1 - i; // The "mirror" bit index

                int ni = (n >> i) & 1; // Bit i of n
                int nj = (n >> j) & 1; // Bit (length-1-i) of n

                // Rule 1: ni must equal nj
                if (ni != nj) {
                    possible = false;
                    break;
                }

                // While checking, we build *one* possible candidate for x.
                // We are free to choose x_i, which then forces x_j.
                // Let's choose x_i = 0 (for i > 0) and x_0 based on n_0.
                if (i == 0) {
                    // n_0 = x_0 ^ x_{length-1}
                    // Since we set x_{length-1} = 1, we have n_0 = x_0 ^ 1
                    // This means x_0 = n_0 ^ 1
                    x |= ((ni ^ 1) << 0);
                } else {
                    // For other bits, let's set x_i = 0.
                    // n_i = x_i ^ x_j => n_i = 0 ^ x_j => x_j = n_i
                    x |= (ni << j);
                }
            }

            // If the palindrome check failed, try the next length
            if (!possible) {
                continue;
            }

            // Rule 2: Check the middle bit if length is odd
            if (length % 2 == 1) {
                int mid = length / 2;
                // n_mid = x_mid ^ x_mid = 0
                if (((n >> mid) & 1) == 1) {
                    possible = false;
                }
                // We can set x_mid = 0 (it's already 0 in our candidate x)
            }

            // If all rules passed, we have a valid candidate x.
            // Now we must verify it.
            if (possible) {
                // We check if f(x) (the reverse)
                // actually XORs with x to produce n.
                if ((x ^ calculateF(x)) == n) {
                    return true;
                }
            }
        }

        // We checked all possible lengths and found no solution
        return false;
    }

    /**
     * Calculates f(x) - the binary reverse of x without leading zeros.
     * e.g., f(12) = f(1100) = 0011 -> 11 = 3
     */
    private static int calculateF(int x) {
        if (x == 0)
            return 0;
        // Reverses all 32 bits. e.g., 12 (0...01100) -> (00110...0)
        int reversed = Integer.reverse(x);
        // Finds original leading zeros. e.g., 12 has 28
        int leadingZeros = Integer.numberOfLeadingZeros(x);
        // Shift the reversed number right to drop its new leading zeros,
        // which correspond to the original's significant bits.
        // e.g., (00110...0) >>> 28 = (0...00011) = 3
        return reversed >>> leadingZeros;
    }
}
