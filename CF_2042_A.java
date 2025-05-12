import java.util.Arrays;
import java.util.Scanner;

public class CF_2042_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }

            int req = 0;
            Arrays.sort(a);
            int ans = 0;
            req = 0;
            for (int i = n - 1; i >= 0; i--) {
                req += a[i];
                if (req >= k) {
                    break;
                } else if (req < k && i - 1 >= 0 && k - req < a[i - 1]) {
                    ans += k - req;
                    req += k - req;
                    break;
                }
            }
            if (req < k) {
                ans += k - req;
                req += k - req;
            }
            System.out.println(ans);
        }
        input.close();
    }
}