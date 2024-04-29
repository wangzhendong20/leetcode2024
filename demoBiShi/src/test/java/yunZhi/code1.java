package yunZhi;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String[] arr = new String[11];
            arr[0] = "...........";
            arr[1] = "..*******..";
            arr[2] = "..*..*..*..";
            arr[3] = "..*******..";
            arr[4] = "..*..*..*..";
            arr[5] = "..*******..";
            arr[6] = ".....*.....";
            arr[7] = "..*******..";
            arr[8] = ".....*.....";
            arr[9] = ".*********.";
            arr[10] = "...........";

            String[] arr_n = new String[11];
            for (int i = 0; i < 11; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < arr[i].length(); j++) {
                    for (int k = 0; k < n; k++) {
                        sb.append(arr[i].charAt(j));
                    }
                }
                arr_n[i] = sb.toString();
            }

            for (int i = 0; i < 11; i++) {
                String s = arr_n[i];
                for (int j = 0; j < n; j++) {
                    System.out.println(s);
                }
            }
        }
    }
}
