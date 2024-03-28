package xieCheng;

import java.util.Scanner;

public class code2 {
    /**
     * ac
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String mAndn = in.nextLine();
            String[] split = mAndn.split(" ");
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                String s = in.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(i) == '0') {
                        nums[i][j] = 0;
                    } else {
                        nums[i][j] = 1;
                    }
                }
            }
            System.out.println(getCount(nums,m,n));
        }
    }

    private static long getCount(int[][] nums, int m, int n) {
        long count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 0) {
                    count++;
                    j++;
                }
            }
        }
        return count;
    }
}
