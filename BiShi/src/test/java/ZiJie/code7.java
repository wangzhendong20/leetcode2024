package ZiJie;

import java.util.List;
import java.util.Scanner;

public class code7 {
    /**
     * 过了49/50个点
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n+1];
            for (int i = 1; i <= n; i++) {
                nums[i] = in.nextInt();
            }

            System.out.println(getEng(nums));
            break;
        }
    }

    private static int getEng(int[] nums) {
        int ans = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 1; i--) {
            if ((ans + nums[i]) % 2 == 1) {
                ans = (ans + nums[i]+1) / 2;
            } else {
                ans = (ans + nums[i]) / 2;
            }
        }
        return ans;
    }
}
