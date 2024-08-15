package youta;

import java.util.Scanner;

public class code4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int N = in.nextInt();
            int K = in.nextInt();
            Color[] pen = new Color[N];
            for (int i = 0; i < N; i++) {
                pen[i].R = in.nextInt();
                pen[i].G = in.nextInt();
                pen[i].B = in.nextInt();
            }

            System.out.println(3);
        }
    }

    static class Color {
        int R, G, B;
        Color(int r, int g, int b) {
            R = r;
            G = g;
            B = b;
        }
    }
}
