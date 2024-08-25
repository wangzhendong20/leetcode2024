package OPPO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            int mex = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                while (map.containsKey(mex) && map.get(nums[i]) == 1){
                    mex++;
                }
            }

            for (int i = 0; i < n; i++) {
                map.put(nums[i], map.get(nums[i]) - 1);

                int newMex = 0;
                while (map.containsKey(newMex) && map.get(newMex) > 0) {
                    newMex++;
                }

                if (newMex < mex) {
                    System.out.print(newMex + " ");
                } else {
                    System.out.print((mex) + " ");
                }
                map.put(nums[i], map.get(nums[i]) + 1);
            }

        }
    }
}
