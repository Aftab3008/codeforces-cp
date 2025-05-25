package div_2_1026;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            String s = input.next();

            int totalCount = 0;
            boolean notPossible = false;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    totalCount++;
                } else if (s.charAt(i) == ')') {
                    totalCount--;
                }

                if (i != 0 && i != s.length() - 1 && totalCount <= 0) {
                    System.out.println("YES");
                    notPossible = true;
                    break;
                }
            }

            if (!notPossible) {
                System.out.println("NO");
            }
        }
        input.close();
    }
}
