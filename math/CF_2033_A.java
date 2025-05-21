package math;

import java.util.Scanner;

public class CF_2033_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = 0;
            int i = 1;

            while (Math.abs(x) <= n) {
                int move = 2 * i - 1;

                if (i % 2 == 1) {
                    x -= move;
                } else {
                    x += move;
                }

                if (Math.abs(x) > n) {
                    if (i % 2 == 1) {
                        System.out.println("Sakurako");
                    } else {
                        System.out.println("Kosuke");
                    }
                    break;
                }

                i++;
            }
        }

        scanner.close();
    }
}
