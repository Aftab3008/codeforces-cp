import java.util.Scanner;

public class CF_2074_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int l, r, d, u;
            l = input.nextInt();
            r = input.nextInt();
            d = input.nextInt();
            u = input.nextInt();

            double s1 = Math.sqrt(Math.pow(l, 2) + Math.pow(d, 2));
            double s2 = Math.sqrt(Math.pow(r, 2) + Math.pow(d, 2));
            double s3 = Math.sqrt(Math.pow(l, 2) + Math.pow(u, 2));
            double s4 = Math.sqrt(Math.pow(r, 2) + Math.pow(u, 2));
            double d1 = Math.sqrt(Math.pow(l + r, 2));
            double d2 = Math.sqrt(Math.pow(d + u, 2));

            if (s1 == s2 && s1 == s3 && s1 == s4 && d1 == d2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        input.close();
    }
}
