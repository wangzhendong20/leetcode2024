package weiZhong;

import java.util.Scanner;

public class code3 {
    static boolean flag = true;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int s = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();

                backtracking(x,s,a,b,c,d,flag);
                if (!flag) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        }
    }

    private static boolean backtracking(int x, int s, int a, int b, int c, int d, boolean flag) {
        if (x >= s) {
            return true;
        }

        if (!flag && ((x + c < s) && (x + d < s) && (x+c+b) >= s)) {
            return false;
        }

        if (flag && ((x + a < s) && (x + b < s) && (x+a+d) >=s )){
            return false;
        }

        if (flag) {
            for (int i = a; i <= b; i++) {
                flag = false;
                if (!backtracking(x+i,s,a,b,c,d,flag)) {
                    return true;
                }
                flag = true;
            }
        } else {
            for (int i = c; i <= d; i++) {
                flag = true;
                if (!backtracking(x+i,s,a,b,c,d,flag)) {
                    return true;
                }
                flag = false;
            }
        }

        return false;
    }
}
