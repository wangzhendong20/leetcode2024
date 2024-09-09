package qunaer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            String[] strArr = new String[n];
            for (int i = 0; i < n; i++) {
                strArr[i] = String.valueOf(arr[i]);
            }

            Arrays.sort(strArr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1+o2).compareTo(o2+o1);
                }
            });

            for (int i = 0; i < n; i++) {
                System.out.println(strArr[i] + " ");
            }

        }
    }
}
