package ZiJie;

import java.util.Scanner;

public class code6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if (n == 1024) {
                System.out.println(0);
                break;
            }
            int diff = 1024 - n;
            System.out.println(getCoins(diff));
            break;
        }
    }

    private static int getCoins(int n) {
        int SixFour = 0, Sixteen = 0, four = 0, one = 0;
        while (n > 0) {
            if (n >= 64) {
                SixFour = n / 64;
                n -= SixFour * 64;
            } else if (n >= 16) {
                Sixteen = n / 16;
                n -= Sixteen * 16;
            } else if (n >= 4) {
                four = n / 4;
                n -= four * 4;
            } else if (n >= 1) {
                one = n;
                n -= one * 1;
            }
        }

        return SixFour + Sixteen + four + one;
    }
}
