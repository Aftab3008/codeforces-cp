import java.util.*;

public class CF_2057_B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }

            Map<Integer, Integer> freq = new HashMap<>();
            for (int x : a) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            List<Integer> counts = new ArrayList<>(freq.values());
            Collections.sort(counts);

            int distinct = counts.size();
            for (int c : counts) {
                if (k >= c) {
                    k -= c;
                    distinct--;
                } else {
                    break;
                }
            }

            System.out.println(Math.max(1, distinct));
        }
        input.close();
    }
}
