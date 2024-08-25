package bilibili;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClosestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 读入测试数据组数

        while (T-- > 0) {
            int n = sc.nextInt(); // 数的个数
            int m = sc.nextInt(); // 运算结果的限制
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt(); // 读入每个数
            }

            System.out.println(findClosestSum(nums, m));
        }

        sc.close();
    }

    private static int findClosestSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        Set<Integer> dp = new HashSet<>();
        dp.add(nums[0]);  // 初始化第一个元素
        // 遍历数组中的每个元素
        for (int i = 1; i < n; i++) {
            Set<Integer> nextDp = new HashSet<>();
            for (int sum : dp) {
                nextDp.add(sum + nums[i]);
                nextDp.add(sum - nums[i]);
            }
            dp = nextDp;
        }
        // 找到最接近目标值的和
        int closestSum = Integer.MAX_VALUE;
        for (int sum : dp) {
            if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                closestSum = sum;
            }
        }
        return Math.abs(closestSum - target);
    }
}
