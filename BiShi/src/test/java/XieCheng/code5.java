package XieCheng;

import java.util.Scanner;

public class code5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            System.out.println(getCount(s));
        }
    }

    private static int getCount(String s) {
        char[] charArray = s.toCharArray();
        int ans = 0;
        int zero = 0;
        int one = 0;
        int left = 0;
//        boolean flag = false;
        for (int i = 0; left < charArray.length;) {
            if (charArray[left] == '1') {
                left++;
                i++;
                one = 0;
                zero = 0;
                continue;
            }

            if (charArray[i] == '0') {
                    zero++;
                if (zero > one) {
                    ans++;
                }
                i++;
            } else {
                one++;
                if (zero > one) {
                    ans++;
                } else {
                    left = ++i;
                    one = 0;
                    zero = 0;
                }
            }


            if (i == charArray.length) {
                left++;
                zero = 0;
                one = 0;
                i = left;
            }
        }
        return ans;
    }
}
