package zhongAn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            int[] nums = new int[26];
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                nums[s.charAt(i) - 'a'] = i+1;
                list.add(Arrays.stream(nums).toArray());
            }
            for (int[] ints : list) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }
}
