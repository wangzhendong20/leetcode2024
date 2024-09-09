package didi;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            if (n == 2) {
                System.out.println(m);
                continue;
            }

            System.out.println(2*(long)m);
        }
    }
}
