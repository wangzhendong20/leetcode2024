package dewu;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arrA = new int[n];
            int[] arrB = new int[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arrB[i] = in.nextInt();
            }

            int ans = 1;
            int left = 0;
            for (int i = 1; i < n; i++) {
                if ((arrA[i] > arrA[i-1] && arrB[i] < arrB[i-1]) || (arrA[i] < arrA[i-1] && arrB[i] > arrB[i-1])
                        || (Math.abs(arrA[i] - arrA[i-1]) != Math.abs(arrB[i] - arrB[i-1]))) {
                    ans = Math.max(ans, i - left);
                    left = i;
                }
            }

            ans = Math.max(ans, n - left);
            System.out.println(ans);
        }
    }
}
