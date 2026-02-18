package div_3_1027;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = Integer.parseInt(s);
            int k = (int) Math.sqrt(n);
            if ((long) k * k == n) {
                System.out.println(0 + " " + k);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}