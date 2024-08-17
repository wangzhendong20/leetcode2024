package mihayou;

import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = in.nextInt();
            }
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                int x = in.nextInt();
                int count = 0;
                for (int j = l; j <= r; j++) {
                    if (arr[j] == x) {
                        count += j - l;
                        count += r - j;
                        count++;
                    }
                }

                System.out.println(count);
            }

        }
    }
}
