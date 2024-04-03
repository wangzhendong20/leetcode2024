package HuaWei.huawei0419;

import java.util.*;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());

            int[] diff = new int[(int) Math.pow(10,6)+1];
            int start = (int) Math.pow(10,6)+1;
            int end = 0;

            for (int i = 0; i < n; i++) {
                String[] split = in.nextLine().split(" ");
                int curStart = Integer.parseInt(split[0]);
                int curEnd = Integer.parseInt(split[1]);
                start = Math.min(curStart,start);
                end = Math.max(curEnd,end);
                diff[curStart] += 1;  //开始位置+1
                diff[curEnd+1] -= 1;  //结束的后一个位置-1
            }

            int[] res = new int[end + 1];
            res[0] = diff[0];
            for (int i = 1; i <= end; i++) {
                //记录当前时间片总共有多少个任务
                res[i] += res[i - 1] + diff[i];
            }

            int ans = 0;
            for (int i = start; i < end + 1; i++) {
                int r = res[i];
                if (r == 0) {
                    ans++;
                } else if (r == 1) {
                    ans += 3;
                } else {
                    ans += 4;
                }
            }

            System.out.println(ans);
        }

    }
}
