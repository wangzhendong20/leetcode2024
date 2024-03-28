package xieCheng;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class code4 {
    /**
     * 10%
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextLong();
            }

            System.out.println(getCount(nums,n));
        }
    }

    private static long getCount(long[] nums, int n) {
        HashSet<Long> set = new HashSet<>();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            while (num >= (long) 1) {
                list.add(num);
                set.add(num);
                num -= (long) 1;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                set.add(list.get(i) * list.get(j));
            }
        }

        long count = set.size();
        return (count % (long) (10e9 + 7));
    }
}
