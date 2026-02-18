package div_3_1027;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int zeros = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    zeros++;
            }
            int half = n / 2;
            int y = half - k;
            if (zeros >= y && (zeros - y) % 2 == 0 && zeros <= k + half) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
