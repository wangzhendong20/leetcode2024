package yunZhi;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long n = in.nextLong();
            long m = in.nextLong();
            long k = in.nextLong();

            if (m < n) {
                System.out.println(1);
                continue;
            }

            long ans = 1L;
            long loop = 1L;
            long extra = m - n;
            long need = 1L;
            while (extra >= need) {
                ans++;
                extra -= need;

                if (2 * loop + 1 <= k) {
                    need = 2 * loop + 1;
                    loop++;
                } else {
                    need = k;
                }
            }

            System.out.println(ans);
        }
    }
}
