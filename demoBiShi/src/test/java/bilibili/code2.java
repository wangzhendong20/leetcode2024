package bilibili;

import java.util.Collections;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine(); // 跳过空行
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();

            sb.append(s.substring(k-1, s.length()));
            int end = n - k + 1;
            String substring = s.substring(0, k-1);
            if (end % 2 == 1) {
                StringBuilder subsb = new StringBuilder(substring);
                subsb.reverse();
                sb.append(subsb);
            } else {
                sb.append(substring);
            }

            System.out.println(sb);
        }
    }

}
