package arrays;

import java.util.Scanner;

//Wrong Solution
public class CF_2106_D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = input.nextInt();
            }
            int lastIndex = -1;
            int ithflower = 0;
            int flowerIndex[] = new int[n];
            for (int i = 0; i < n; i++) {
                flowerIndex[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = lastIndex + 1; j < m; j++) {
                    if (a[i] > b[j]) {
                        lastIndex = j;
                        flowerIndex[ithflower] = j;
                        ithflower++;
                        break;
                    }
                }
            }
        }
        input.close();
    }
}
