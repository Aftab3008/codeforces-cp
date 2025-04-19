import java.math.BigInteger;
import java.util.Scanner;

public class CF_2093_B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- > 0) {
            BigInteger n = input.nextBigInteger();
            int result = 0;
            int firstDigit = -1;
            BigInteger ten = BigInteger.TEN;

            while (n.compareTo(BigInteger.ZERO) > 0) {
                int digit = n.mod(ten).intValue();

                if (firstDigit == -1) {
                    if (digit != 0) {
                        firstDigit = digit;
                    } else {
                        result++;
                    }
                } else if (digit != 0) {
                    result++;
                }

                n = n.divide(ten);
            }

            System.out.println(result);
        }

        input.close();
    }
}
