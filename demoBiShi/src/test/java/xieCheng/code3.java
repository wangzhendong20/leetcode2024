package xieCheng;

import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            StringBuilder sb = new StringBuilder();
            boolean[] used = new boolean[n+1];
            backtracking(n,k,m,sb,used);
            System.out.println(count);

        }
    }
    static int count = 0;
    private static void backtracking(int n,int k, int m,StringBuilder sb, boolean[] used) {
        if ( sb.length() == m && sb.charAt(0) != '0' && Integer.parseInt(new String(sb)) > k) {
            count++;
        }
        if (sb.length() > m || (sb.length() > 0 && sb.charAt(0) == '0')) {
            return;
        }

        for (int j = 0; j <= n;j++) {
            if (used[j]) continue;
            used[j] = true;
            sb.append(j);
            backtracking(n,k,m,sb,used);
            sb.deleteCharAt(sb.length() - 1);
            used[j] = false;
        }

    }
}
