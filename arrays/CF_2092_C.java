package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Wrong
public class CF_2092_C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            long sum = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
                sum += arr[i];
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] % 2 == 0) {
                    even.add(arr[i]);
                } else {
                    odd.add(arr[i]);
                }
            }
            if (even.isEmpty() || odd.isEmpty()) {
                System.out.println(max);
                continue;
            }
            if (n == 2) {
                System.out.println(sum);
                continue;
            }
            Collections.sort(even);
            Collections.sort(odd);
            int minEven = even.get(0);
            int minOdd = odd.get(0);
            long candidate = sum - Math.min(minEven, minOdd);
            System.out.println(Math.max(max, candidate));
        }
        input.close();
    }
}