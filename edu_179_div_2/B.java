package edu_179_div_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] a = new int[m][3];
            for (int i = 0; i < m; i++) {
                a[i][0] = input.nextInt();
                a[i][1] = input.nextInt();
                a[i][2] = input.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> fib = computeFibonacci(n);
            for (int i = 0; i < m; i++) {
                int W0 = a[i][0];
                int L0 = a[i][1];
                int H0 = a[i][2];
                int f0 = fib.get(0);
                if (f0 > W0 || f0 > L0 || f0 > H0) {
                    sb.append('0');
                    continue;
                }
                int remW, remL;
                if (W0 >= L0) {
                    remW = W0 - f0;
                    remL = L0;
                } else {
                    remW = W0;
                    remL = L0 - f0;
                }
                int H_rem = H0;
                int lastLayerH = f0;
                boolean ok = true;
                for (int j = 1; j < fib.size(); j++) {
                    int f = fib.get(j);
                    if (f <= remW && f <= remL) {
                        if (remW >= remL) {
                            remW -= f;
                        } else {
                            remL -= f;
                        }
                    } else {
                        H_rem -= lastLayerH;
                        if (H_rem < f) {
                            ok = false;
                            break;
                        }
                        if (f > W0 || f > L0) {
                            ok = false;
                            break;
                        }
                        lastLayerH = f;
                        if (W0 >= L0) {
                            remW = W0 - f;
                            remL = L0;
                        } else {
                            remW = W0;
                            remL = L0 - f;
                        }
                    }
                }
                if (ok) {
                    H_rem -= lastLayerH;
                    if (H_rem < 0) {
                        ok = false;
                    }
                }
                sb.append(ok ? '1' : '0');
            }
            System.out.print(sb);
            System.out.println();
        }
        input.close();
    }

    private static ArrayList<Integer> computeFibonacci(int n) {
        ArrayList<Integer> fibonacci = new ArrayList<>();
        if (n <= 0)
            return fibonacci;
        fibonacci.add(1);
        if (n == 1) {
            return new ArrayList<>(fibonacci);
        }
        fibonacci.add(2);
        for (int i = 2; i < n; i++) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
        }
        Collections.reverse(fibonacci);
        return fibonacci;
    }
}
