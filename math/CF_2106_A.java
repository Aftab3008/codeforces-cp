package math;

import java.util.Scanner;

public class CF_2106_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int count1 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    count1++;
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    result += count1 + 1;
                } else {
                    result += count1 - 1;
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
