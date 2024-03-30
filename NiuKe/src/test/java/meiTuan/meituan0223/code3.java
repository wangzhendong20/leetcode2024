package meiTuan.meituan0223;

import java.util.HashMap;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            int[] nums = new int[n];
            int index = 0;
            for (String s : in.nextLine().split(" ")) {
                nums[index++] = Integer.parseInt(s);
            }
            char[] flag = new char[n];
            String inputFlag = in.nextLine();
            for (int i = 0; i < n; i++) {
                flag[i] = inputFlag.charAt(i);
            }

            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i+1) {
                    if (flag[i] == 'R' && flag[map.get(i+1)] == 'R') {
                        ans++;
                        int tmp = nums[i];
                        nums[i] = nums[map.get(i+1)];
                        nums[map.get(i+1)] = tmp;
                        map.put(nums[i], map.get(i+1));
                        map.put(i+1,i);
                    } else {
                        ans = -1;
                        break;
                    }
                }
            }
            System.out.println(ans);

        }
    }
}
