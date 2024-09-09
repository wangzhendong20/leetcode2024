package qunaer;

import java.util.Arrays;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long m = in.nextLong();

            int[] nums = new int[n];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int ans = -1;

            for (int i = 1; i <= n; i++) {

                Arrays.sort(nums,0,i);
                Arrays.sort(arr,0,i);
                long sum = 0L;

                for (int j = 0; j < i; j++) {
                    sum += (long) nums[j] * arr[j];
                }
                if (sum >= m) {
                    ans = i;
                    break;
                }
            }

            System.out.println(ans);
        }
    }
}
