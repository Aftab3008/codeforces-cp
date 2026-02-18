package div_3_1027;

import java.util.Scanner;

public class D {
    static int[][] board = new int[1000000000][1000000000];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = input.nextInt();
                a[i][1] = input.nextInt();
            }
            for (int[] point : a) {
                int x = point[0];
                int y = point[1];
                board[x][y] = 1;
            }
            int rowCnt = 1;
            int maxCol = 1;
            int colCnt = 0;
            int total = 0;
            for (int i = 0; i < board.length; i++) {
                int cnt = 0;
                int cntCol = 0;
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1) {
                        cnt++;
                        total++;
                        cnt = j;
                    }
                }
                if (cnt == 1) {
                    int empty = rowCnt * cntCol - total;
                    if (empty == 0) {
                        rowCnt++;
                        maxCol = Math.max(maxCol, cntCol);
                    } else {
                        maxCol = Math.max(maxCol, cntCol);
                    }
                } else if (cnt > 1) {
                    colCnt++;
                    if (cntCol == 0) {
                        rowCnt++;
                    } else {
                        rowCnt = Math.max(rowCnt, cntCol);
                    }
                } else {
                    colCnt++;
                }
            }
            System.out.println(rowCnt + " " + maxCol);
        }
        input.close();
    }
}
