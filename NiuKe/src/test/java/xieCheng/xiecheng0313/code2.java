package xieCheng.xiecheng0313;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            List<Integer> ans = getCount(nums,n);
            for (Integer an : ans) {
                System.out.println(an);
            }
        }
    }

    private static List<Integer> getCount(int[] nums, int n) {

        List<Integer> ans = new ArrayList<>();

        int[] sortedNums = Arrays.stream(Arrays.copyOf(nums, nums.length))
                .sorted().boxed().mapToInt(Integer::intValue).toArray();

        int[] sums = new int[sortedNums.length+1];
        for (int i = 0; i < sortedNums.length; i++) {
            sums[i+1] += sums[i] + sortedNums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            for (int j = 0; j < sortedNums.length; j++) {
                if (nums[i] == sortedNums[j]){
                    index = j;
                    break;
                }
            }

            int count = ((2*index- nums.length+1) * nums[i]) - (sums[index]) + (sums[nums.length] - sums[index+1]);
            ans.add(count);
        }
        return ans;
    }
}
