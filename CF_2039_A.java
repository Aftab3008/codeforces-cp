import java.util.Scanner;

public class CF_2039_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();

            if (n == 1) {
                System.out.println(2);
            } else {
                int add = 0;
                for (int i = 1; i <= n; i++) {
                    int value = i + add;
                    System.out.print(value + " ");
                    add++;
                }
                System.out.println();
            }
        }
        input.close();
    }
}