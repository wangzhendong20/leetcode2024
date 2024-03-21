package XieCheng;

import java.util.Arrays;
import java.util.Scanner;

public class code4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int l = in.nextInt();
                int r = in.nextInt();
                int[] nums = new int[n];
                for (int j = 0; j < n; j++) {
                    nums[j] = in.nextInt();
                }
                System.out.println(getCount(nums,l,r));
            }
        }
    }

    private static int getCount(int[] nums, int l, int r) {
        Arrays.sort(nums);
        if (nums[nums.length-1] <= l) return -1;
        if (nums[0] >= r) return -1;

        int left = 0;
        int right = nums.length-1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= l) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i < nums.length; i++) {
            if (nums[i] <= r) {
                right = i;
                break;
            }
        }
        int i = 0,j= nums.length-1;
        while (i < left && j > right) {
            if (nums[j] > r && nums[i] < l) {
                nums[j]--;
                nums[i]++;
                ans++;
            } else {
                if (nums[j] == r) {
                    j--;
                }
                if (nums[i] == l) {
                    i++;
                }
            }
        }
        if ( i == left && j == right) return ans;
        if (i == left) {
            i = 0;
            while (i < right) {
                if (nums[j] > r) {
                    nums[j]--;
                    nums[i]++;
                    ans++;
                }
                if (nums[i] == r) {
                    i++;
                }
            }
        } else if (j == right) {
            j = nums.length - 1;
            while (j > left) {
                if (nums[i] < l) {
                    nums[j]--;
                    nums[i]++;
                    ans++;
                }
                if (nums[j] == l) {
                    j--;
                }
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < l || nums[k] > r) {
                return -1;
            }
        }

        return ans;

    }

}
