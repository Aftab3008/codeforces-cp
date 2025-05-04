import java.util.Scanner;

//https://codeforces.com/blog/SpyrosAliv

public class CF_1843_C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            long n = input.nextLong();
            long sum = n;
            while (n > 1) {
                n /= 2;
                sum += n;
            }
            System.out.println(sum);
        }
        input.close();
    }
}
