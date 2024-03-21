package XieCheng;

import java.util.LinkedList;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            boolean[] used = new boolean[n+1];
            backtracking(n,used);
            System.out.println(res);
            break;
        }
    }

    static int res = 0;
    static LinkedList<Integer> path = new LinkedList<>();

    private static void backtracking(int n, boolean[] used) {
        if (path.size() == n) {
            res++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i] == true) continue;
            if (path.isEmpty()) {
                used[i] = true;
                path.add(i);
                backtracking(n,used);
                path.removeLast();
                used[i] = false;
            } else {
                if (!isSuShu(path.getLast() + i)) {
                    used[i] = true;
                    path.add(i);
                    backtracking(n,used);
                    path.removeLast();
                    used[i] = false;
                }
            }
        }
    }

    private static boolean isSuShu(int num) {

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
