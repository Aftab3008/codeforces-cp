import java.util.Scanner;

public class CF_2065_B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            String s = input.next();
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    ans++;
                }
            }
            if (ans == 0) {
                System.out.println(n);
            } else {
                System.out.println(1);
            }
        }
        input.close();
    }
}