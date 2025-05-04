import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CF_2036_B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            long total = 0;
            for (int i = 0; i < k; i++) {
                int b = input.nextInt();
                int c = input.nextInt();
                map.put(b, map.getOrDefault(b, 0) + c);
                total += c;
            }
            if (map.size() <= n) {
                System.out.println(total);
            } else {
                List<Integer> profits = new ArrayList<>(map.values());
                profits.sort(Collections.reverseOrder());
                long ans = 0;
                for (int i = 0; i < n; i++) {
                    ans += profits.get(i);
                }
                System.out.println(ans);
            }
        }
        input.close();
    }
}
