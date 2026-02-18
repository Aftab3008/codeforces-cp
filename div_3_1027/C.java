package div_3_1027;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int count = 0;
            int last = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (count == 0 || a > last + 1) {
                    count++;
                    last = a;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
