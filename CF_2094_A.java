import java.util.Scanner;

public class CF_2094_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            String s = input.next();
            String m = input.next();
            String e = input.next();

            System.out.println(s.charAt(0) + "" + m.charAt(0) + "" + e.charAt(0));
        }
        input.close();
    }
}
