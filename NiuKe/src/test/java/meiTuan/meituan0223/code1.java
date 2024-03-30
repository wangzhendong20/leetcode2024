package meiTuan.meituan0223;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] nAndm = in.nextLine().split(" ");
            int n = Integer.parseInt(nAndm[0]);
            int m = Integer.parseInt(nAndm[1]);
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                String input = in.nextLine();
                for (int j = 0; j < input.length(); j++) {
                    nums[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                }
            }
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (nums[i][j] + nums[i+1][j] + nums[i][j+1] + nums[i+1][j+1] == 2) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

}
