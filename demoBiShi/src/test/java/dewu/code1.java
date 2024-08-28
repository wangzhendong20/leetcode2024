package dewu;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] s = in.nextLine().split(" ");
            String s1 = s[0];
            String s2 = s[1];
            int ans = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 == c2) {
                    continue;
                } else {
                    if (c1 > c2) {
                        ans += c1 - c2;
                    } else {
                        ans += c1 - '0' + 1 + '9' - c2;
                    }
                }

            }
            System.out.println(ans);
        }
    }
}
