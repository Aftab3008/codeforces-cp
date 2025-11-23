import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF_2152_A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int a = input.nextInt();
                set.add(a);
            }

            System.out.println(set.size() * 2 - 1);
        }

        input.close();
    }
}
