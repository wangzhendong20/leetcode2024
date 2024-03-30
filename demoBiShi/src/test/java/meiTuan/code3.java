package meiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code3 {
    /**
     * 60%   看不懂题
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String t = in.nextLine();
            int len = s.length();
            int ans = 0;
            int changeS = 0;
            int changeT = 0;
            int index = len - 1;
            for (; index >= 0; index--) {
                if (s.charAt(index) != t.charAt(index)) {
                    break;
                }
            }

            if (index == -1) {
                System.out.println(ans);
                continue;
            }


            for (int i = 1; i < index; i++) {
                if (s.charAt(i) != s.charAt(i-1)) {
                    changeS++;
                }
                if (t.charAt(i) != t.charAt(i-1)) {
                    changeT++;
                }
            }
            int flag = 2;
            if (changeS > changeT) {
                String tmp = s;
                s = t;
                t = tmp;
                flag = 1;
            }
            List<Pair> list = new ArrayList<>();
            char cur = t.charAt(index);
            for (int i = index; i >= 0; i--) {
                if (s.charAt(i) != cur) {
                    ans++;
                    cur = s.charAt(i);
                    list.add(new Pair(i+1,cur));
                }
            }
            System.out.println(ans);
            for (Pair pair : list) {
                System.out.println(flag + " " + pair.val + " "+ pair.c);
            }

        }
    }
    static class Pair {
        int val;
        char c;
        public Pair(int val, char c) {
            this.val = val;
            this.c = c;
        }
    }
}
