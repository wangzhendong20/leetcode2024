package ZiJie;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.valueOf(in.nextLine());
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                System.out.println(fixStr(s));
            }
            break;
        }

    }

    private static String fixStr(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int j = 0; //记录当前是第几个不同元素
        boolean flag = false;  //记录第一种情况
        boolean flag2 = false;  //记录第二三种情况
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                if (!flag && !flag2) { //每次最多有两个，如果前面是AA被标记，那个只能加一个B
                    sb.append(s.charAt(i));
                    flag2 = true;
                } else {
                    if (!flag) {  //如果前面有个AA，如果是A，不刷新。如果是AABB情况，则将flag2刷新。
                        flag2 = false;
                    }
                }
                flag = true;
                j = 0;
            } else {
                sb.append(s.charAt(i));
                j++;
                if (j == 2) { //遇到两个不同元素再刷新
                    flag2 = false;
                    j = 0;
                }
                flag = false; //遇到新元素就刷新
            }
        }

        return String.valueOf(sb);
    }
}
