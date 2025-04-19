import java.util.Scanner;

public class CF_2093_C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int x = input.nextInt();
            int y = input.nextInt();

            if (isPrime(x) && y == 1) {
                System.out.println("YES");
            } else if (x == 1 && y == 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        input.close();
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
