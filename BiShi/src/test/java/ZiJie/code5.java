package ZiJie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class code5 {
    /**
     * 过了一半，之后超时
     */
    static int res = Integer.MAX_VALUE;
    static LinkedList<Integer> path = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[][] prices = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    prices[i][j] = in.nextInt();
                }
            }
            boolean[] used = new boolean[n];
            backtracking(prices,n,0,used,0);

            System.out.println(res);
        }
    }

    private static void backtracking(int[][] prices, int cityNum, int lastCity, boolean[] used, int sum) {
        if (path.size() == cityNum) {
            sum += prices[lastCity][0];
            if (sum < res) res = sum;
            return;
        }

        if (sum > res) {
            return;
        }

        for (int i = 0; i < cityNum; i++) {
            if (used[i] == true) continue;
            used[i] = true;
            path.add(i);
            sum += prices[lastCity][i];
            backtracking(prices,cityNum,i,used,sum);
            sum -= prices[lastCity][i];
            path.removeLast();
            used[i] = false;
        }
    }
}
