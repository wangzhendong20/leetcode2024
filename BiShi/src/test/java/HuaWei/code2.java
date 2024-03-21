package HuaWei;

import java.util.Arrays;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt(); // 读取数组元素
            }
            int[] vals = deleteArray(nums);
            for (int val : vals) {
                System.out.println(val);
            }
            break;
        }
    }

    public static int[] deleteArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[left]) {
                left++;
                nums[left] = nums[i];
            }
        }

        return Arrays.copyOfRange(nums,0,left+1);
    }
}
