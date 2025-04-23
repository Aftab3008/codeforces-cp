import java.util.Scanner;

public class CF_2075_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();

            int steps;

            if (k == 1) {
                steps = (n % 2 == 0) ? -1 : n;
            } else if (k % 2 == 0) {
                if (n % 2 == 0) {
                    steps = 1 + (n / k);
                } else {
                    steps = (n + k - 1) / k;
                }
            } else {
                if (n % 2 == 0) {
                    steps = (n + k - 2) / (k - 1);
                } else {
                    if (n < k) {
                        steps = 1;
                    } else {
                        steps = 1 + (n - 2) / (k - 1);
                    }
                }
            }

            System.out.println(steps);
        }

        input.close();
    }
}